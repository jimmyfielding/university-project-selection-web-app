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
import static webapps2019.ejb.SupervisorServiceEJB.getCurrentUser;
import webapps2019.entity.ProjectTopicEntity;
import webapps2019.entity.SupervisorEntity;
import webapps2019.jsf.ProjectTopic;

/**
 * EJB that supports business logic for project topic registration
 * @author jf
 */
@DeclareRoles({"supervisor", "admin"})
@Stateless
public class RegisterProjectTopicServiceEJB {

    @PersistenceContext(unitName = "webapps2019PU")
    EntityManager em;

    /**
     * Business logic for registering a project topic
     * @param title
     * @param description 
     */
    public void registerProjectTopicAdmin(String title, String description) {

        ProjectTopicEntity projectTopic = new ProjectTopicEntity(title, description);

        em.persist(projectTopic);

    }

}
