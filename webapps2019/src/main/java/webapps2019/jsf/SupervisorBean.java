/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapps2019.jsf;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import webapps2019.ejb.SupervisorServiceEJB;

/**
 * JSF backing bean that supports the rendering of data involving the
 * SupervisorEntity table
 *
 * @author jf
 */
@Named
@SessionScoped
public class SupervisorBean implements Serializable {

    @EJB
    SupervisorServiceEJB supervisor;

    String sussexId;
    String name;
    String surname;
    String department;
    String email;
    String telephoneNumber;
    HtmlDataTable dataTable;
    HtmlDataTable dataTableNot;
    Project projectToView;
    Notification notificationToView;

    /**
     * Creates a new instance of SupervisorBean
     */
    public SupervisorBean() {
    }

    /**
     * Creates a new instance of SupervisorBean
     *
     * @param sussexId String value from JSF page
     * @param name String value from JSF page
     * @param surname String value from JSF page
     * @param department String value from JSF page
     * @param email String value from JSF page
     * @param telephoneNumber String value from JSF page
     */
    public SupervisorBean(String sussexId, String name, String surname, String department, String email, String telephoneNumber) {
        this.sussexId = sussexId;
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
    }

    /**
     * Invokes the business logic for retrieving the Students that the logged in
     * Supervisor supervised from the StudentEntity table in the database
     *
     * @return List of Supervisee DTO's that contains Student data
     */
    public List<Supervisee> getAllSupervisees() {

        return supervisor.getMySupervisees();

    }

    /**
     * Invokes the business logic for retrieving the project of a given Student
     * that is supervised by the logged in Supervisor from the ProjectEntity
     * table in the database
     *
     * @param s String sussexId
     * @param t String title
     * @return Project DTO that contains project data
     */
    public Project getSuperviseeProject(String s, String t) {

        return supervisor.getMySuperviseesProject(s, t);

    }

    /**
     * Invokes the business logic for retrieving data and creating Notifications
     * for the logged in Supervisor from the ProjectEntity table in the database
     *
     * @return List of Notification DTO's that contain Notification data
     */
    public List<Notification> getAllNotifications() {

        return supervisor.getAllNotifications();

    }

    /**
     * Method that sets the Project DTO referred to by the row of the selected
     * element in the data table to be the projectToView attribute
     *
     * @return outcome supervisees-project
     */
    public String viewProject() {

        Supervisee supervisee = (Supervisee) dataTable.getRowData();

        projectToView = getSuperviseeProject(supervisee.getSussexId(), "");

        return "supervisees-project";

    }

    /**
     * Method that sets Project referred to in the Notification DTO referred to
     * by the row of the selected element in the data table to be the
     * projectToView attribute
     *
     * @param t Project title
     * @return outcome student-notification
     */
    public String viewNotificationProject(String t) {

        Notification notification = (Notification) dataTableNot.getRowData();

        projectToView = getSuperviseeProject(notification.getSussexId(), t);

        return "student-notification";

    }

    /**
     * Invokes the business logic for a Supervisor Accepting a Student proposed
     * project/Accepting them as a supervisee
     *
     * @param t Project title
     * @return outcome student-notification-accepted
     */
    public String acceptProject(String t) {

        supervisor.acceptProject(t);

        return "student-notification-accepted";
    }

    /**
     * Invokes the business logic for a Supervisor Accepting a Student proposed
     * project/Accepting them as a supervisee
     *
     * @param t Project title
     * @return outcome student-notification-rejected
     */
    public String rejectProject(String t) {

        supervisor.rejectProject(t);

        return "student-notification-rejected";

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

    public HtmlDataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(HtmlDataTable dataTable) {
        this.dataTable = dataTable;
    }

    public HtmlDataTable getDataTableNot() {
        return dataTableNot;
    }

    public void setDataTableNot(HtmlDataTable dataTableNot) {
        this.dataTableNot = dataTableNot;
    }

    public Project getProjectToView() {
        return projectToView;
    }

    public void setProjectToView(Project projectToView) {
        this.projectToView = projectToView;
    }

    public Notification getNotificationToView() {
        return notificationToView;
    }

    public void setNotificationToView(Notification notificationToView) {
        this.notificationToView = notificationToView;
    }

}
