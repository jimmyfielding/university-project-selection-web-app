/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapps2019.ejb;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import webapps2019.entity.ProjectEntity;
import webapps2019.entity.ProjectEntityPK;
import webapps2019.entity.ProjectTopicEntity;
import webapps2019.entity.StudentEntity;
import webapps2019.entity.SupervisorEntity;
import webapps2019.jsf.Project;

/**
 *
 * EJB that supports business logic for student interactions with the system
 * @author jf
 */
@DeclareRoles({"student", "admin"})
@Stateless
public class StudentServiceEJB {

    @PersistenceContext(unitName = "webapps2019PU")
    EntityManager em;

    /**
     * Business logic for getting available projects
     * @return List of Project DTOs
     */
    public List<Project> getAvailableProjects() {

        return em.createNamedQuery("findAvailableProjects").setParameter("status", "available").getResultList();

    }

    /**
     * Business logic for getting a student's proposed project
     * @return Project DTO
     */
    public Project getMyProposedProject() {

        List<ProjectEntity> tmp = em.createNamedQuery("findSuperviseesProject").setParameter("sussexId", getCurrentUser()).getResultList();

        if (!(tmp.isEmpty())) {
            return new Project();
        } else {
            ProjectEntity projectEntity = tmp.get(0);
            Project project = new Project(projectEntity.getProjectEntityPk().getTitle(), projectEntity.getDescription(), projectEntity.getRequiredSkills());
            return project;
        }

    }

    /**
     * Business logic for proposing a project
     * @param title
     * @param description
     * @param requiresSkills
     * @param status
     * @param projectTopics
     * @param supervisedBy 
     */
    public void proposeProject(String title, String description, String requiresSkills, String status, List<String> projectTopics, String supervisedBy) {

        SupervisorEntity supervisor = (SupervisorEntity) em.createNamedQuery("findSupervisor").setParameter("sussexId", supervisedBy).getSingleResult();
        StudentEntity student = (StudentEntity) em.createNamedQuery("findStudent").setParameter("sussexId", getCurrentUser()).getSingleResult();
        List<ProjectTopicEntity> topics = new ArrayList<ProjectTopicEntity>();

        for (String s : projectTopics) {
            topics.add((ProjectTopicEntity) em.createNamedQuery("findProjectTopic").setParameter("title", s).getSingleResult());
        }

        ProjectEntity project = new ProjectEntity(new ProjectEntityPK(title, supervisedBy), description, requiresSkills, "proposed", topics, supervisor, student);

        em.persist(project);

    }

    /**
     * Business logic for selecting a project
     * @param title 
     */
    public void selectProject(String title) {

        ProjectEntity project = (ProjectEntity) em.createNamedQuery("findProjectEntity").setParameter("title", title).getSingleResult();
        StudentEntity student = (StudentEntity) em.createNamedQuery("findStudent").setParameter("sussexId", getCurrentUser()).getSingleResult();

        project.setStatus("selected");
        project.setChosenBy(student);

        em.merge(project);

    }

    /**
     * Business logic for retrieving a project
     * @param title
     * @return Project DTO
     */
    public Project getProject(String title) {

        return (Project) em.createNamedQuery("findProject").setParameter("title", title).getSingleResult();

    }

    /**
     * Boolean that checks if a student has already proposed a project
     * @return true if no project proposed
     */
    public boolean canProposeProject() {

        return em.createNamedQuery("findSuperviseesProject").setParameter("sussexId", getCurrentUser()).getResultList().isEmpty();

    }

    /**
     * Business logic for getting current user credentials
     * @return String
     */
    public static String getCurrentUser() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest r = (HttpServletRequest) context.getExternalContext().getRequest();
        String currentUser = r.getUserPrincipal().getName();
        return currentUser;
    }

}
