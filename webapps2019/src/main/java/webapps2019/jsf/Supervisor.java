/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapps2019.jsf;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * DTO for the SupervisorEntity table
 *
 * @author jf
 */
public class Supervisor {

    @JsonProperty
    String sussexId;

    @JsonProperty
    String name;

    @JsonProperty
    String surname;

    @JsonProperty
    String department;

    @JsonProperty
    String email;

    @JsonProperty
    String telephoneNumber;

    /**
     * Creates a new instance of SupervisorBean
     *
     * @param sussexId String
     * @param name String
     * @param surname String
     * @param department String
     * @param email String
     * @param telephoneNumber String
     */
    public Supervisor(String sussexId, String name, String surname, String department, String email, String telephoneNumber) {
        this.sussexId = sussexId;
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
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

}
