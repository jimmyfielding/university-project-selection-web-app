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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import webapps2019.entity.ProjectTopicEntity;
import webapps2019.jsf.ProjectTopic;

/**
 * EJB that supports business logic for Project Topic related interactions
 * @author jf
 */
@DeclareRoles({"supervisor", "admin"})
@Stateless
public class ProjectTopicServiceEJB {

    @PersistenceContext(unitName = "webapps2019PU")
    EntityManager em;

    /**
     * Business logic for retrieving all project topics
     * @return List of ProjectTopic DTOs
     */
    public List<ProjectTopic> getAllProjectTopics() {

        List<ProjectTopicEntity> projectTopicEntities = em.createNamedQuery("findAllProjectTopics").getResultList();
        ArrayList<ProjectTopic> projectTopics = new ArrayList<>();

        for (ProjectTopicEntity p : projectTopicEntities) {

            projectTopics.add(new ProjectTopic(p.getTitle(), p.getDescription()));

        }

        return projectTopics;

    }

}
