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
import webapps2019.jsf.Student;

/**
 * Singleton EJB that returns students as JSON objects as part of a RESTful
 * service
 *
 * @author jf
 */
@Singleton
@Path("/student")
public class RSStudent {

    @PersistenceContext(unitName = "webapps2019PU")
    EntityManager em;

    /**
     * Response for GET request for students relating to a supervisor
     *
     * @param supervisorid sussexId of supervisor
     * @return list of students related to supervisor as JSON objects
     */
    @GET
    @Path("/{supervisorid}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getStudents(@PathParam("supervisorid") String supervisorid) {
        List<Student> myStudents = retrieveSupervisees(supervisorid);
        if (myStudents == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(myStudents).build();
        }
    }

    /**
     * Retrieves student data from the StudentEntity table in the database to be
     * returned as part of this RESTful service
     *
     * @param supervisorId sussexId to search by
     * @return list of students related to supervisor
     */
    public List<Student> retrieveSupervisees(String supervisorId) {

        return em.createNamedQuery("findStudents").setParameter("sussexId", supervisorId).getResultList();

    }

}
