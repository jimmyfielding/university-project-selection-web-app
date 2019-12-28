package webapps2019.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import webapps2019.entity.ProjectEntity;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-03T10:42:26")
@StaticMetamodel(StudentEntity.class)
public class StudentEntity_ { 

    public static volatile SingularAttribute<StudentEntity, String> sussexId;
    public static volatile SingularAttribute<StudentEntity, String> surname;
    public static volatile SingularAttribute<StudentEntity, String> name;
    public static volatile SingularAttribute<StudentEntity, String> course;
    public static volatile SingularAttribute<StudentEntity, ProjectEntity> selectedProject;
    public static volatile SingularAttribute<StudentEntity, String> email;

}