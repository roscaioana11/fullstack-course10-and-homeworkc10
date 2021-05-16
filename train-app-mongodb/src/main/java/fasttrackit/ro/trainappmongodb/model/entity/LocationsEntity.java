package fasttrackit.ro.trainappmongodb.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "locations")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocationsEntity {
    @Id
    private String id;

    private String city;
}
