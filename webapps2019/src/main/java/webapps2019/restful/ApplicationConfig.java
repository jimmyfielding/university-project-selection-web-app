/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapps2019.restful;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 * Application Config for RESTful service.
 *
 * @author jf
 */
@javax.ws.rs.ApplicationPath("/webapps2019")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method. It is automatically
     * populated with all resources defined in the project. If required, comment
     * out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(webapps2019.restful.RSProject.class);
        resources.add(webapps2019.restful.RSStudent.class);
        resources.add(webapps2019.restful.RSSupervisor.class);
    }

}
