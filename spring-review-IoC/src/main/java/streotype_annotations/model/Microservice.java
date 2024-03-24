package streotype_annotations.model;

import org.springframework.stereotype.Component;

@Component
public class Microservice {
    public void getTotalHours(){
        System.out.println("Total Hours: " + 30);
    }
}
