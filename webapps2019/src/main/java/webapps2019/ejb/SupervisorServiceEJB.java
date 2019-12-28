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
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import webapps2019.entity.ProjectEntity;
import webapps2019.entity.ProjectEntityPK;
import webapps2019.entity.ProjectTopicEntity;
import webapps2019.entity.SupervisorEntity;
import webapps2019.jsf.Notification;
import webapps2019.jsf.Project;
import webapps2019.jsf.ProjectTopic;
import webapps2019.jsf.Supervisee;

/**
 * EJB that implements the business logic for supervisor interactions with the system
 * 
 * @author jf
 */
@DeclareRoles({"supervisor"})
@Stateless
public class SupervisorServiceEJB {

    @PersistenceContext(unitName = "webapps2019PU")
    EntityManager em;

    /**
     * Business logic for registering a new project
     * @param title
     * @param description
     * @param requiresSkills
     * @param status
     * @param projectTopics 
     */
    public void registerProject(String title, String description, String requiresSkills, String status, List<String> projectTopics) {

        try {
            SupervisorEntity supervisor = em.find(SupervisorEntity.class, getCurrentUser());
            //SupervisorEntity supervisor = (SupervisorEntity) em.createNamedQuery("findSupervisor").setParameter("sussexId", getCurrentUser()).getSingleResult();
            List<ProjectTopicEntity> topics = new ArrayList<>();
            for (String s : projectTopics) {
                topics.add((ProjectTopicEntity) em.createNamedQuery("findProjectTopic").setParameter("title", s).getSingleResult());
            }

            ProjectEntity project = new ProjectEntity(new ProjectEntityPK(title, getCurrentUser()), description, requiresSkills, status, topics, supervisor);

            em.persist(project);
        } catch (NoResultException e) {
            System.out.println(getCurrentUser());
        }

    }

    /**
     * Business logic for retrieving a supervisor's notifications
     * @return list of Notification DTOs
     */
    public List<Notification> getAllNotifications() {

        return em.createNamedQuery("findMyNotifications").setParameter("sussexId", getCurrentUser()).setParameter("statusAval", "available").setParameter("statusAcc", "accepted").getResultList();

    }

    /**
     * Business logic for retrieving a supervisor's supervisees
     * @return list of Supervisee DTOs
     */
    public List<Supervisee> getMySupervisees() {

        return em.createNamedQuery("findSupervisees").setParameter("sussexId", getCurrentUser()).setParameter("status", "accepted").getResultList();

    }

    /**
     * Business logic for retrieving all project topics
     * @return list of ProjectTopic DTOs
     */
    public List<ProjectTopic> getAllProjectTopics() {

        return em.createNamedQuery("findAllProjectTopics").getResultList();

    }

    /**
     * Business logic for getting all of a supervisor's supervised projects
     * @return list of Project DTOs
     */
    public List<Project> getAllMyProjets() {

        return em.createNamedQuery("findSupervisorsProjects").setParameter("sussexId", getCurrentUser()).getResultList();

    }

    /**
     * Business logic for getting a supervisee's project
     * @param s
     * @param t
     * @return Project DTO
     */
    public Project getMySuperviseesProject(String s, String t) {

        return unravelProjectEntity((ProjectEntity) em.createNamedQuery("findSuperviseesProjectEntity").setParameter("sussexId", s).getSingleResult());

    }

    /**
     * Business logic for getting a ProjectEntity referring to a supervisee's project
     * @param s
     * @return ProjectEntity
     */
    public ProjectEntity getMySuperviseesProjectEntity(String s) {

        return (ProjectEntity) em.createNamedQuery("findSuperviseesProjectEntity").setParameter("sussexId", s).getSingleResult();

    }

    /**
     * Business logic for accepting a project
     * @param s 
     */
    public void acceptProject(String s) {

        ProjectEntity project = (ProjectEntity) em.createNamedQuery("findProjectEntity").setParameter("title", s).setParameter("sussexId", getCurrentUser()).getSingleResult();

        project.setStatus("accepted");

        em.merge(project);
    }

    /**
     * Business logic for rejecting a project
     * @param s 
     */
    public void rejectProject(String s) {

        ProjectEntity project = (ProjectEntity) em.createNamedQuery("findProjectEntity").setParameter("title", s).setParameter("sussexId", getCurrentUser()).getSingleResult();

        if (project.getStatus().equals("proposed")) {
            em.detach(project);
        } else {
            project.setStatus("available");
            em.merge(project);
        }

    }

    /**
     * Business logic for unravelling a ProjectEntity into a ProjectEntity DTO
     * @param dto
     * @return Project DTO
     */
    public Project unravelProjectEntity(ProjectEntity dto) {

        ArrayList<ProjectTopic> topics = new ArrayList<>();

        for (ProjectTopicEntity p : dto.getProjectTopics()) {
            topics.add(new ProjectTopic(p.getTitle(), p.getDescription()));
        }

        return new Project(dto.getProjectEntityPk().getTitle(), dto.getDescription(), dto.getRequiredSkills(), topics, dto.getProjectEntityPk().getSupervisedByPk());
    }

    /**
     * Business logic for getting current user
     * @return String
     */
    public static String getCurrentUser() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest r = (HttpServletRequest) context.getExternalContext().getRequest();
        String currentUser = r.getUserPrincipal().getName();
        return currentUser;
    }

}
