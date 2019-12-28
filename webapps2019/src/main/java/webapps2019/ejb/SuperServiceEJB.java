/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapps2019.ejb;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import webapps2019.entity.SystemUser;
import webapps2019.entity.SystemUserGroup;

/**
 * EJB that supports general services
 * @author jf
 */

@Stateless
public class SuperServiceEJB {

    @PersistenceContext(unitName = "webapps2019PU")
    EntityManager em;

    /**
     * Empty constructor
     */
    public SuperServiceEJB() {
    }

    /**
     * Implements the business logic of returning the email of the current
     * logged in user (fundraiser or charity)
     *
     * @return
     */
    public static String getCurrentUser() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest r = (HttpServletRequest) context.getExternalContext().getRequest();
        String currentUser = r.getUserPrincipal().getName();
        return currentUser;
    }

    /**
     * Implements the business logic of registering a user into the general
     * database. Will be used in the less general classes to complete the
     * registration process
     *
     * @param username
     * @param userPassword
     */
    public void registerUser(String username, String userPassword, String groupname) {

        SystemUser sys_user;
        SystemUserGroup sys_user_group;

        List<SystemUser> newUser = em.createNamedQuery("findUsers").setParameter("username", username).getResultList();
        if (newUser.isEmpty()) {
            sys_user = new SystemUser(username, encryptPassword(userPassword));
            sys_user_group = new SystemUserGroup(username, groupname);
            em.persist(sys_user);
            em.persist(sys_user_group);
        } else {
            throw new EJBException();
        }

    }

    /**
     * Implements the business logic of encrypting passwords in the database
     *
     * @param password
     * @return encrypted password
     */
    public String encryptPassword(String password) {

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String passwordToEncrypt = password;
            md.update(passwordToEncrypt.getBytes("UTF-8"));
            byte[] digest = md.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < digest.length; i++) {
                sb.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
            }

            String encryptedPassword = sb.toString();

            return encryptedPassword;
        } catch (NoSuchAlgorithmException ex) {
            System.err.println(ex.getMessage());
            return null;
        } catch (UnsupportedEncodingException ex) {
            System.err.println(ex.getMessage());
            return null;
        }

    }

}
