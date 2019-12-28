/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapps2019.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

/**
 * Entity that represents a Supervisor in the system
 *
 * @author jf
 */
@Entity

@NamedQueries({
    @NamedQuery(name = "findSupervisor", query = "SELECT s FROM SupervisorEntity s WHERE s.id LIKE :sussexId")
})
public class SupervisorEntity implements Serializable {

    @Id
    String id;

    @NotNull
    String name;

    @NotNull
    String surname;

    @NotNull
    String email;

    @NotNull
    String department;

    @NotNull
    long telephoneNumber;

    /**
     * Creates a new instance of SupervisorEntity
     */
    public SupervisorEntity() {
    }

    /**
     * Creates a new instance of SupervisorEntity
     *
     * @param id
     * @param name
     * @param surname
     * @param email
     * @param department
     * @param telephoneNumber
     */
    public SupervisorEntity(String id, String name, String surname, String email, String department, long telephoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.department = department;
        this.telephoneNumber = telephoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public long getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(long telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

}
