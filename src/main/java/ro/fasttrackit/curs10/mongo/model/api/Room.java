package ro.fasttrackit.curs10.mongo.model.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private String id;
    private String roomNumber;
    private boolean hasTv;
    private boolean doubleBed;
}
