/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapps2019.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.validation.constraints.NotNull;

/**
 * Entity that represents a Project Topic in the system
 *
 * @author jf
 */
@Entity

@NamedQueries({
    @NamedQuery(name = "findAllProjectTopics", query = "SELECT p FROM ProjectTopicEntity p")
})
@NamedNativeQuery(name = "findProjectTopics", query = "SELECT pt.title AS pt_title, pt.description AS pt_description FROM ProjectTopicEntity pt LEFT JOIN ProjectEntity p ON pt.title = title AND supervisedBy.id = ?", resultSetMapping = "ProjectTopics")
@SqlResultSetMapping(
        name = "ProjectTopics",
        classes = {
            @ConstructorResult(
                    targetClass = webapps2019.jsf.ProjectTopic.class,
                    columns = {
                        @ColumnResult(name = "title", type = String.class)
                        ,
                    @ColumnResult(name = "description", type = String.class)})})

public class ProjectTopicEntity implements Serializable {

    @Id
    String title;

    @NotNull
    String description;

    @ManyToMany
    List<ProjectEntity> projects;

    /**
     * Creates new instance of ProjectTopicEntity
     */
    public ProjectTopicEntity() {
    }

    /**
     * Creates a new instance of ProjectTopicEntity
     *
     * @param title
     * @param description
     */
    public ProjectTopicEntity(String title, String description) {
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

    public List<ProjectEntity> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectEntity> projects) {
        this.projects = projects;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.title);
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
        final ProjectTopicEntity other = (ProjectTopicEntity) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return true;
    }

}
