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
import webapps2019.ejb.RegisterProjectTopicServiceEJB;
import webapps2019.ejb.SupervisorServiceEJB;

/**
 *
 * JSF backing bean that supports the functionality for registering a new
 * project topic
 *
 * @author jf
 */
@Named
@RequestScoped
public class ProjectTopicBean {

    @EJB
    RegisterProjectTopicServiceEJB projectTopicService;

    @EJB
    ProjectTopicServiceEJB projectTopic;

    String title;
    String description;

    /**
     * Creates a new instance of ProjectTopicBean
     */
    public ProjectTopicBean() {
    }

    /**
     * Creates a new instance of ProjectTopicBean
     *
     * @param title String
     * @param description String
     */
    public ProjectTopicBean(String title, String description) {
        this.title = title;
        this.description = description;
    }

    /**
     * Invokes the business logic for a supervisor registering a new
     * ProjectTopic
     */
    public void registerProjectTopicSupervisor() {

        projectTopicService.registerProjectTopicAdmin(title, description);

    }

    /**
     * Invokes the business logic for an admin registering a new ProjectTopic
     * (with createdBy field set to null)
     */
    public void registerProjectTopicAdmin() {

        projectTopicService.registerProjectTopicAdmin(title, description);

    }

    /**
     * Invokes business logic for retrieving all project topic data from Project
     * Topic table
     *
     * @return list of Project Topic DTOs
     */
    public List<ProjectTopic> retrieveAllProjectTopics() {

        return projectTopic.getAllProjectTopics();

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

}
