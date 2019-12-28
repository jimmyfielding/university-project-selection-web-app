/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapps2019.entity;

import java.io.Serializable;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * Composite key for the ProjectEntity class
 *
 * @author jf
 */
@Embeddable
public class ProjectEntityPK implements Serializable {

    String title;
    String supervisedByPk;

    /**
     * Creates a new instance of ProjectEntityPK
     */
    public ProjectEntityPK() {
    }

    /**
     * Creates a new instance of ProjectEntityPK
     *
     * @param title
     * @param supervisedByPk
     */
    public ProjectEntityPK(String title, String supervisedByPk) {
        this.title = title;
        this.supervisedByPk = supervisedByPk;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSupervisedByPk() {
        return supervisedByPk;
    }

    public void setSupervisedByPk(String supervisedByPk) {
        this.supervisedByPk = supervisedByPk;
    }

}
