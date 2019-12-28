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
 *
 * JSF backing bean that supports the functionality for registering a new
 * student
 *
 * @author jf
 */
@Named
@RequestScoped
public class StudentRegistrationBean {

    @EJB
    UserRegistrationServiceEJB student;

    String sussexId;
    String name;
    String surname;
    String email;
    String course;
    String password;

    /**
     * Creates a new instance of StudentRegistrationBean
     */
    public StudentRegistrationBean() {
    }

    /**
     * Invokes the business logic for registering a new Student in the database
     *
     * @return outcome for navigation to successful or failed registration page
     */
    public String registerStudent() {

        try {
            student.registerUser(sussexId, password, "student");
            student.addStudent(sussexId, name, surname, email, course);
        } catch (EJBException e) {
            return "registration-failed";
        }

        return "student-registration-success";
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
