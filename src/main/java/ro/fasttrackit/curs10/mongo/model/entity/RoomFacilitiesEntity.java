package ro.fasttrackit.curs10.mongo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class RoomFacilitiesEntity {
    private boolean hasTv;
    private boolean doubleBed;
}
