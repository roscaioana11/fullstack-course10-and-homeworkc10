package fasttrackit.ro.trainappmongodb.model;

import lombok.Value;

@Value
public class TrainFilter {
    String location;
    String model;
    Integer minCart;
    Integer maxCart;
}
