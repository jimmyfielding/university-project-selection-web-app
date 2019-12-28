/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapps2019.jsf;

/**
 * DTO for displaying data from the ProjectTopic table
 *
 * @author jf
 */
public class ProjectTopic {

    public String title;
    public String description;

    /**
     * Creates a new instance of ProjectTopic
     */
    public ProjectTopic() {
    }

    /**
     * Creates a new instance of ProjectTopic
     *
     * @param title String
     * @param description String
     */
    public ProjectTopic(String title, String description) {
        this.title = title;
        this.description = description;
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
