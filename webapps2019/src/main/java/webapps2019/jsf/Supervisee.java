/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapps2019.jsf;

/**
 *
 * DTO for displaying partial data from the StudentEntity table
 *
 * @author jf
 */
public class Supervisee {

    String sussexId;
    String name;
    String surname;
    String projectTitle;

    /**
     * Creates a new instance of SupervisorBean
     *
     * @param sussexId String
     * @param name String
     * @param surname String
     * @param projectTitle String
     */
    public Supervisee(String sussexId, String name, String surname, String projectTitle) {
        this.sussexId = sussexId;
        this.name = name;
        this.surname = surname;
        this.projectTitle = projectTitle;
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

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

}
