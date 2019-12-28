/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapps2019.jsf;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.inject.Named;
import webapps2019.ejb.StudentServiceEJB;

/**
 * JSF backing bean that supports the rendering of data involving the
 * StudentEntity table
 *
 * @author jf
 */
@Named
@SessionScoped
public class StudentBean implements Serializable {

    @EJB
    StudentServiceEJB student;

    String sussexId;
    String name;
    String surname;
    String email;
    String course;
    Project projectToView;
    HtmlDataTable dataTable;

    /**
     * Creates a new instance of StudentBean
     */
    public StudentBean() {
    }

    /**
     * Invokes the business logic for retrieving the Projects that are listed as
     * available in the ProjectEntity table in the database
     *
     * @return List of Project DTO's that contains Project data
     */
    public List<Project> getAvailableProjects() {

        return student.getAvailableProjects();

    }

    /**
     * Method that sets the Project DTO referred to by the row of the selected
     * element in the data table to be the projectToView attribute
     *
     * @return outcome select-project
     */
    public String viewProject() {

        projectToView = (Project) dataTable.getRowData();

        return "select-project";

    }

    /**
     * Invokes the business logic for retrieving a single Project from the
     * ProjectEntity table in the database
     *
     * @return Project DTO that contains Project data
     */
    public Project getProjectToView(String s) {

        return student.getProject(s);

    }

    /**
     * Invokes the business logic for selecting a supervisors project in the
     * database
     *
     * @param title Project Title
     * @return outcome for success or failure
     */
    public String selectProject(String title) {

        if (student.canProposeProject()) {
            student.selectProject(title);
            return "select-project-successful";
        } else {
            return "select-project-failure";
        }

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

    public Project getProjectToView() {
        return projectToView;
    }

    public void setProjectToView(Project projectToView) {
        this.projectToView = projectToView;
    }

    public HtmlDataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(HtmlDataTable dataTable) {
        this.dataTable = dataTable;
    }

}
