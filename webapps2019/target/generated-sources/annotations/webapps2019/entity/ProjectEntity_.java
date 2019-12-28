package webapps2019.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import webapps2019.entity.ProjectEntityPK;
import webapps2019.entity.ProjectTopicEntity;
import webapps2019.entity.StudentEntity;
import webapps2019.entity.SupervisorEntity;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-03T10:42:26")
@StaticMetamodel(ProjectEntity.class)
public class ProjectEntity_ { 

    public static volatile SingularAttribute<ProjectEntity, SupervisorEntity> supervisedBy;
    public static volatile ListAttribute<ProjectEntity, ProjectTopicEntity> projectTopics;
    public static volatile SingularAttribute<ProjectEntity, StudentEntity> chosenBy;
    public static volatile SingularAttribute<ProjectEntity, ProjectEntityPK> projectEntityPk;
    public static volatile SingularAttribute<ProjectEntity, String> description;
    public static volatile SingularAttribute<ProjectEntity, String> requiredSkills;
    public static volatile SingularAttribute<ProjectEntity, String> status;

}