/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapps2019.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.EmbeddedId;

/**
 * Entity that represents a project in the system
 *
 * @author jf
 */
@Entity

@NamedQueries({
    @NamedQuery(name = "findSupervisees", query = "SELECT NEW webapps2019.jsf.Supervisee(s.sussexId, s.name, s.surname, p.projectEntityPk.title) FROM ProjectEntity p JOIN p.chosenBy s WHERE p.supervisedBy.id LIKE :sussexId AND p.status LIKE :status")
    ,
    @NamedQuery(name = "findStudents", query = "SELECT NEW webapps2019.jsf.Student(s.sussexId, s.name, s.surname, s.email, s.course) FROM ProjectEntity p JOIN p.chosenBy s WHERE p.supervisedBy.id LIKE :sussexId AND p.status LIKE :status")
    ,
    @NamedQuery(name = "findSuperviserEntity", query = "SELECT p.supervisedBy FROM ProjectEntity p WHERE p.chosenBy.sussexId LIKE :sussexId")
    ,
    @NamedQuery(name = "findSuperviser", query = "SELECT NEW webapps2019.jsf.Supervisor(p.supervisedBy.id, p.supervisedBy.name, p.supervisedBy.surname, p.supervisedBy.department ,p.supervisedBy.email, p.supervisedBy.telephoneNumber) FROM ProjectEntity p WHERE p.chosenBy.sussexId LIKE :sussexId")
    ,
    @NamedQuery(name = "findAvailableProjects", query = "SELECT NEW webapps2019.jsf.Project(p.projectEntityPk.title, p.description, p.projectEntityPk.supervisedByPk) FROM ProjectEntity p WHERE p.status LIKE :status")
    ,
    @NamedQuery(name = "findSupervisorsProjects", query = "SELECT NEW webapps2019.jsf.Project(p.projectEntityPk.title, p.description, p.requiredSkills, p.projectEntityPk.supervisedByPk) FROM ProjectEntity p WHERE p.supervisedBy.id LIKE :sussexId")
    ,
    @NamedQuery(name = "findProposedProjects", query = "SELECT NEW webapps2019.jsf.Project(p.projectEntityPk.title, p.description, p.requiredSkills, p.projectEntityPk.supervisedByPk) FROM ProjectEntity p WHERE p.supervisedBy.id LIKE :sussexID AND p.status LIKE :status")
    ,
    @NamedQuery(name = "findSuperviseesProjectEntity", query = "SELECT p FROM ProjectEntity p WHERE p.chosenBy.sussexId LIKE :sussexId")
    ,
//    @NamedQuery(name = "findProject", query = "SELECT NEW webapps2019.ejb.ProjectDTO(p.projectEntityPk.title, p.description, p.requiredSkills, pt, p.projectEntityPk.supervisedByPk) FROM ProjectEntity p JOIN p.projectTopics pt WHERE p.projectEntityPk.title LIKE :title AND p.projectEntityPk.supervisedByPk LIKE :sussexId")
//    ,
    @NamedQuery(name = "findProjectEntity", query = "SELECT p FROM ProjectEntity p WHERE p.projectEntityPk.title LIKE :title AND p.projectEntityPk.supervisedByPk LIKE :sussexId")
    ,
    @NamedQuery(name = "findMyNotifications", query = "SELECT NEW webapps2019.jsf.Notification(s.sussexId, s.name ,s.surname, p.status) FROM ProjectEntity p JOIN p.chosenBy s WHERE p.supervisedBy.id LIKE :sussexId AND p.status NOT LIKE :statusAval AND p.status NOT LIKE :statusAcc")
})
public class ProjectEntity implements Serializable {

    @EmbeddedId
    ProjectEntityPK projectEntityPk;

    @NotNull
    String description;

    @NotNull
    String requiredSkills;

    @NotNull
    String status;

    @NotNull
    @ManyToMany
    List<ProjectTopicEntity> projectTopics;

    @NotNull
    @ManyToOne
    @JsonbTransient
    SupervisorEntity supervisedBy;

    @OneToOne
    StudentEntity chosenBy;

    /**
     * Creates a new instance of ProjectEntity
     */
    public ProjectEntity() {
    }

    /**
     * Creates a new instance of ProjectEntity
     *
     * @param projectEntityPk
     * @param description
     * @param requiredSkills
     * @param status
     * @param projectTopics
     * @param supervisedBy
     * @param chosenBy
     */
    public ProjectEntity(ProjectEntityPK projectEntityPk, String description, String requiredSkills, String status, List<ProjectTopicEntity> projectTopics, SupervisorEntity supervisedBy, StudentEntity chosenBy) {
        this.projectEntityPk = projectEntityPk;
        this.description = description;
        this.requiredSkills = requiredSkills;
        this.status = status;
        this.projectTopics = projectTopics;
        this.supervisedBy = supervisedBy;
        this.chosenBy = chosenBy;
    }

    /**
     * Creates a new instance of ProjectEntity
     *
     * @param projectEntityPk
     * @param description
     * @param requiredSkills
     * @param status
     * @param projectTopics
     * @param supervisedBy
     */
    public ProjectEntity(ProjectEntityPK projectEntityPk, String description, String requiredSkills, String status, List<ProjectTopicEntity> projectTopics, SupervisorEntity supervisedBy) {
        this.projectEntityPk = projectEntityPk;
        this.description = description;
        this.requiredSkills = requiredSkills;
        this.status = status;
        this.projectTopics = projectTopics;
        this.supervisedBy = supervisedBy;
    }

    public ProjectEntityPK getProjectEntityPk() {
        return projectEntityPk;
    }

    public void setProjectEntityPk(ProjectEntityPK projectEntityPk) {
        this.projectEntityPk = projectEntityPk;
    }

    public String getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(String requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ProjectTopicEntity> getProjectTopics() {
        return projectTopics;
    }

    public void setProjectTopics(List<ProjectTopicEntity> projectTopics) {
        this.projectTopics = projectTopics;
    }

    public StudentEntity getChosenBy() {
        return chosenBy;
    }

    public void setChosenBy(StudentEntity chosenBy) {
        this.chosenBy = chosenBy;
    }

    public SupervisorEntity getSupervisedBy() {
        return supervisedBy;
    }

    public void setSupervisedBy(SupervisorEntity supervisedBy) {
        this.supervisedBy = supervisedBy;
    }

}
