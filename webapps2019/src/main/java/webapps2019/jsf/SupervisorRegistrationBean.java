/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapps2019.jsf;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import webapps2019.ejb.UserRegistrationServiceEJB;

/**
 * JSF backing bean that supports the functionality for registering a new
 * supervisor
 *
 * @author jf
 */
@Named
@RequestScoped
public class SupervisorRegistrationBean {

    @EJB
    UserRegistrationServiceEJB userReg;

    String sussexId;
    String name;
    String surname;
    String department;
    String email;
    String telephoneNumber;
    String password;

    /**
     * Creates a new instance of SupervisorRegistrationBean
     */
    public SupervisorRegistrationBean() {
    }

    /**
     * Invokes the business logic for registering a new Supervisor in the
     * database
     *
     * @return outcome for navigation to successful or failed registration page
     */
    public String registerSupervisor() {

        try {
            userReg.registerUser(sussexId, password, "supervisor");
            userReg.addSupervisor(sussexId, name, surname, department, email, Long.parseLong(telephoneNumber));
        } catch (EJBException e) {
            return "registration-failed";
        }

        return "supervisor-registration-success";

    }

    public String getSussexId() {
        return sussexId;
    }

    public void setSussexId(String sussexId) {
        this.sussexId = sussexId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
