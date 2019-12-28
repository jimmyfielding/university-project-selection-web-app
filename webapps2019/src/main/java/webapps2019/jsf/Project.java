/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapps2019.jsf;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * DTO for displaying partial data from the ProjectEntity table
 *
 * @author jf
 */
public class Project {

    @JsonProperty
    String title;

    @JsonProperty
    String description;

    @JsonProperty
    String requiredSkills;

    @JsonProperty
    List<ProjectTopic> topics;

    @JsonProperty
    String status;

    @JsonProperty
    String supervisor;

    /**
     * Creates a new instance of Project
     *
     * @param title String
     * @param description String
     * @param requiredSkills String
     * @param topics String
     * @param supervisor String
     */
    public Project(String title, String description, String requiredSkills, List<ProjectTopic> topics, String supervisor) {
        this.title = title;
        this.description = description;
        this.requiredSkills = requiredSkills;
        this.topics = topics;
        this.supervisor = supervisor;
    }

    /**
     * Creates a new instance of Project
     *
     * @param title String
     * @param description String
     * @param requiredSkills String
     * @param supervisor String
     */
    public Project(String title, String description, String requiredSkills, String supervisor) {
        this.title = title;
        this.description = description;
        this.requiredSkills = requiredSkills;
        this.supervisor = supervisor;
    }

    /**
     * Creates a new instance of Project
     *
     * @param title String
     * @param description String
     * @param requiredSkills String
     */
    public Project(String title, String description, String requiredSkills) {
        this.title = title;
        this.description = description;
        this.requiredSkills = requiredSkills;
    }

    /**
     * Creates a new instance of Project
     */
    public Project() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public List<ProjectTopic> getTopics() {
        return topics;
    }

    public void setTopics(List<ProjectTopic> topics) {
        this.topics = topics;
    }

}
