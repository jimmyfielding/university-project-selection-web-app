/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapps2019.jsf;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import webapps2019.ejb.UserRegistrationServiceEJB;

/**
 * JSF backing bean that supports the functionality for registering a new admin
 *
 * @author jf
 */
@Named
@RequestScoped
public class AdminRegistrationBean {

    @EJB
    UserRegistrationServiceEJB registration;

    String sussexId;
    String password;

    /**
     * Creates a new instance of AdminRegistrationBean
     */
    public AdminRegistrationBean() {
    }

    /**
     * Invokes the business logic for registering a new admin
     *
     * @return outcome for success or failure
     */
    public String registerAdmin() {

        try {
            registration.registerUser(sussexId, password, "admin");
        } catch (EJBException e) {
            return "registration-failed";
        }

        return "admin-registration-successful";
    }

}
