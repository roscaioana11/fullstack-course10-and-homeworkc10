package ro.fasttrackit.curs10.mongo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "rooms")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomEntity {
    @Id
    private String id;

    private String roomNumber;

    private RoomFacilitiesEntity facilities;

    public RoomEntity(String roomNumber) {
        this.roomNumber = roomNumber;
    }
}
