/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapps2019.restful;

import java.util.List;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import webapps2019.jsf.Project;

/**
 * Singleton EJB that returns Projects as JSON objects as part of a RESTful
 * service
 *
 * @author jf
 */
@Singleton
@Path("/project")
public class RSProject {

    @PersistenceContext(unitName = "webapps2019PU")
    EntityManager em;

    /**
     * Response for GET request for projects relating to a supervisor
     *
     * @param supervisorid sussexId of supervisor
     * @return list of projects related to supervisor as JSON objects
     */
    @GET
    @Path("/{supervisorid}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getProjects(@PathParam("supervisorid") String supervisorid) {
        List<Project> myProjects = retrieveProjects(supervisorid);
        if (myProjects == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(myProjects).build();
        }
    }

    /**
     * Retrieves project data from the ProjectEntity table in the database to be
     * returned as part of this RESTful service
     *
     * @param supervisorId sussexId to search by
     * @return list of projects related to supervisor
     */
    public List<Project> retrieveProjects(String supervisorId) {

        return em.createNamedQuery("findSupervisorsProjects").setParameter("sussexId", supervisorId).getResultList();

    }

}
