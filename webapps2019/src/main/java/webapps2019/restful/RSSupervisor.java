/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapps2019.restful;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import webapps2019.entity.SupervisorEntity;
import webapps2019.jsf.Supervisor;

/**
 * Singleton EJB that returns a supervisor as a JSON object as part of a RESTful
 * service
 *
 * @author jf
 */
@Singleton
@Path("/supervisor")
public class RSSupervisor {

    @PersistenceContext(unitName = "webapps2019PU")
    EntityManager em;

    /**
     * Response for GET request for supervisor relating to a student
     *
     * @param studentid sussexId of student
     * @return supervisor that related to student as JSON object
     */
    @GET
    @Path("/{studentid}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getSupervisor(@PathParam("studentid") String studentid) {

        Supervisor supervisor = retrieveSupervisor(studentid);
        if (supervisor == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(supervisor).build();
        }
    }

    /**
     * Retrieves supervisor data from the SupervisorEntity table in the database
     * to be returned as part of this RESTful service
     *
     * @param studentId sussexId to search by
     * @return supervisor related to student
     */
    public Supervisor retrieveSupervisor(String studentId) {

        SupervisorEntity supervisorEntity = (SupervisorEntity) em.createNamedQuery("findSupervisorEntity").setParameter("sussexId", studentId).getSingleResult();
        Supervisor supervisor = new Supervisor(supervisorEntity.getId(), supervisorEntity.getName(), supervisorEntity.getSurname(), supervisorEntity.getDepartment(), supervisorEntity.getEmail(), String.valueOf(supervisorEntity.getTelephoneNumber()));

        return supervisor;
    }

}
