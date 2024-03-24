package streotype_annotations.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
@Data

public class DataStructure {

    @NonNull //
    private final ExtraHours extraHours;


    public void getTotalHours(){
        System.out.println("Total Hours: " + (20 + extraHours.getHours()));
    }

}
