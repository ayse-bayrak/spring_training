package streotype_annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import streotype_annotations.config.CourseConfig;
import streotype_annotations.model.DataStructure;
import streotype_annotations.model.Microservice;

public class CourseApplication {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(CourseConfig.class);

        DataStructure dataStructure = container.getBean(DataStructure.class);
        Microservice microservice = container.getBean(Microservice.class);

        dataStructure.getTotalHours();
        microservice.getTotalHours();
    }
}
