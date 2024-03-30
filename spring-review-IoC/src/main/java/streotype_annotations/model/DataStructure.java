package streotype_annotations.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
@Data // did not have AllArgConstructor but it has something called requiredArgumentContructor


public class DataStructure {

    @NonNull // it can not be null, it can not be empty
    private final ExtraHours extraHours;
    // I will inject extraneous filed, i am just adding has a relationship


    public void getTotalHours(){
        System.out.println("Total Hours: " + (20 + extraHours.getHours()));
    }

}
