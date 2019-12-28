/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapps2019.jsf;

/**
 * Notification DTO. This class displays notification information creates from
 * the ProjectEntity table.
 *
 * @author jf
 */
public class Notification {

    String sussexId;
    String name;
    String surname;
    String fullName;
    String status;

    /**
     * Creates a new instance of Notification
     *
     * @param sussexId
     * @param name
     * @param surname
     * @param status
     */
    public Notification(String sussexId, String name, String surname, String status) {
        this.sussexId = sussexId;
        this.name = name;
        this.surname = surname;
        this.fullName = name + " " + surname;
        this.status = status;
    }

    /**
     * Converts status into a message to be rendered
     *
     * @return String message
     */
    public String printStatus() {

        if (status.equals("proposed")) {
            return fullName + " proposed a project for you to supervise! View this notification to accept or reject!";
        } else {
            return fullName + " selected your project! View this notification to accept or reject!";
        }

    }

    public String getSussexId() {
        return sussexId;
    }

    public void setSussexId(String sussexId) {
        this.sussexId = sussexId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
