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
import javax.annotation.security.DeclareRoles;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import webapps2019.entity.StudentEntity;
import webapps2019.entity.SupervisorEntity;
import webapps2019.entity.SystemUser;
import webapps2019.entity.SystemUserGroup;

/**
 * EJB that implements the business logic for user registration
 * @author jf
 */
@DeclareRoles({"admin"})
@Stateless
public class UserRegistrationServiceEJB {

    @PersistenceContext(unitName = "webapps2019PU")
    EntityManager em;

    /**
     * Creates a new instance of UserRegistrationServiceEJB
     */
    public UserRegistrationServiceEJB() {
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
     * Adds a new StudentEntity into the StudentEntity table as a new student user is registered
     * @param sussexId String
     * @param name String
     * @param surname String
     * @param email String
     * @param course String
     */
    public void addStudent(String sussexId, String name, String surname, String email, String course) {

        StudentEntity student;

        student = new StudentEntity(sussexId, name, surname, email, course);

        em.persist(student);

    }

    /**
     * Adds a new StudentEntity into the StudentEntity table as a new supervisor user is registered
     * @param sussexId String
     * @param name String
     * @param surname String
     * @param department String
     * @param email String
     * @param telephoneNumber String
     */
    public void addSupervisor(String sussexId, String name, String surname, String department, String email, long telephoneNumber) {

        SupervisorEntity supervisor;

        supervisor = new SupervisorEntity(sussexId, name, surname, department, email, telephoneNumber);

        em.persist(supervisor);

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
