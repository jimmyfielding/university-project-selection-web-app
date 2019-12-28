/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapps2019.jsf;

/**
 * DTO for displaying partial data from the StudentEntity table
 *
 * @author jf
 */
public class Student {

    String sussexId;
    String name;
    String surname;
    String email;
    String course;

    /**
     * Creates a new instance of SupervisorBean
     *
     * @param sussexId String
     * @param name String
     * @param surname String
     * @param email String
     * @param course String
     */
    public Student(String sussexId, String name, String surname, String email, String course) {
        this.sussexId = sussexId;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.course = course;
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

}
