package fasttrackit.ro.trainappmongodb.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "trains")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrainsEntity {
    @Id
    private String id;

    private String model;

    private int carts;

    private String locationId;

    public TrainsEntity(String model, int carts, String locationId) {
        this.model = model;
        this.carts = carts;
        this.locationId = locationId;
    }
}
