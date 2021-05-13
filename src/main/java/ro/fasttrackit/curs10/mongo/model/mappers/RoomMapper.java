package ro.fasttrackit.curs10.mongo.model.mappers;

import org.springframework.stereotype.Component;
import ro.fasttrackit.curs10.mongo.model.api.Room;
import ro.fasttrackit.curs10.mongo.model.entity.RoomEntity;
import ro.fasttrackit.curs10.mongo.model.entity.RoomFacilitiesEntity;

import static java.util.Optional.ofNullable;

@Component
public class RoomMapper implements Mapper<Room,RoomEntity>{
    public Room toApi(RoomEntity entity) {
        if (entity == null) {
            return null;
        }
        var target = new Room();
        target.setRoomNumber(entity.getRoomNumber());
        target.setId(entity.getId());
        ofNullable(entity.getFacilities())
                .ifPresent(facilities -> mapFacilities(target, facilities));

        return target;
    }

    private void mapFacilities(Room target, RoomFacilitiesEntity facilities) {
        target.setHasTv(facilities.isHasTv());
        target.setDoubleBed(facilities.isDoubleBed());
    }

    public RoomEntity toEntity(Room room) {
        if (room == null) {
            return null;
        }
        var target = new RoomEntity();
        target.setId(room.getId());
        target.setRoomNumber(room.getRoomNumber());
        target.setFacilities(RoomFacilitiesEntity.builder()
                .hasTv(room.isHasTv())
                .doubleBed(room.isDoubleBed())
                .build());
        return target;
    }
}
