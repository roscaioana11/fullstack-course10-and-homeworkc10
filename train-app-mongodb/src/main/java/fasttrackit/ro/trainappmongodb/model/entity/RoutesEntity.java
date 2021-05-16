package fasttrackit.ro.trainappmongodb.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "routes")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoutesEntity {
    private String start;
    private String destination;
    private Long length;
    private String trainId;
}
