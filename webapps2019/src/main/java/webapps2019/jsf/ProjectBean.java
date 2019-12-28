/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapps2019.jsf;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import webapps2019.ejb.ProjectTopicServiceEJB;
import webapps2019.ejb.StudentServiceEJB;
import webapps2019.ejb.SupervisorServiceEJB;

/**
 * JSF backing bean that supports the rendering of data involving the Project
 * table
 *
 * @author jf
 */
@Named
@RequestScoped
public class ProjectBean {

    @EJB
    StudentServiceEJB store;
    @EJB
    SupervisorServiceEJB supervisor;

    String title;
    String description;
    String requiredSkills;
    String status;
    List<String> projectTopics;
    String supervisedBy;
    String proposedBy;

    /**
     * Creates a new instance of ProjectBean
     */
    public ProjectBean() {
    }

    /**
     * Creates a new instance of ProjectBean
     *
     * @param title String
     * @param description String
     * @param requiredSkills String
     * @param status String
     */
    public ProjectBean(String title, String description, String requiredSkills, String status) {
        this.title = title;
        this.description = description;
        this.requiredSkills = requiredSkills;
        this.status = status;
    }

    /**
     * Invokes business logic for a student to propose a project
     */
    public void proposeProject() {

        store.proposeProject(title, description, requiredSkills, "proposed", projectTopics, supervisedBy);

    }

    /**
     * Invokes the business logic for a supervisor to register a project
     */
    public void registerProject() {

        supervisor.registerProject(title, description, requiredSkills, "available", projectTopics);

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(String requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getProjectTopics() {
        return projectTopics;
    }

    public void setProjectTopics(List<String> projectTopics) {
        this.projectTopics = projectTopics;
    }

    public String getSupervisedBy() {
        return supervisedBy;
    }

    public void setSupervisedBy(String supervisedBy) {
        this.supervisedBy = supervisedBy;
    }

    public String getProposedBy() {
        return proposedBy;
    }

    public void setProposedBy(String proposedBy) {
        this.proposedBy = proposedBy;
    }

}
