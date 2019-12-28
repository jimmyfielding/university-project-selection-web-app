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
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 * Entity that represents a Student in the system
 *
 * @author jf
 */
@Entity

@NamedQueries({
    @NamedQuery(name = "findStudent", query = "SELECT s FROM StudentEntity s WHERE s.sussexId LIKE :sussexId")
})
public class StudentEntity implements Serializable {

    @Id
    String sussexId;

    @NotNull
    String name;

    @NotNull
    String surname;

    @NotNull
    String email;

    @NotNull
    String course;

    @OneToOne
    ProjectEntity selectedProject;

    /**
     * Creates a new instance of StudentEntity
     */
    public StudentEntity() {
    }

    /**
     * Creates a new instance of StudentEntity
     *
     * @param sussexId
     * @param name
     * @param surname
     * @param email
     * @param course
     */
    public StudentEntity(String sussexId, String name, String surname, String email, String course) {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.sussexId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StudentEntity other = (StudentEntity) obj;
        if (!Objects.equals(this.sussexId, other.sussexId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StudentEntity{" + "sussexId=" + sussexId + '}';
    }

}
