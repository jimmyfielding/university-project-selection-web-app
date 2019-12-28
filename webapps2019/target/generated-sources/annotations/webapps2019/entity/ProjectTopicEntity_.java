package webapps2019.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import webapps2019.entity.ProjectEntity;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-03T10:42:26")
@StaticMetamodel(ProjectTopicEntity.class)
public class ProjectTopicEntity_ { 

    public static volatile ListAttribute<ProjectTopicEntity, ProjectEntity> projects;
    public static volatile SingularAttribute<ProjectTopicEntity, String> description;
    public static volatile SingularAttribute<ProjectTopicEntity, String> title;

}