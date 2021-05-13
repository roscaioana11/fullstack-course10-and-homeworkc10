package ro.fasttrackit.curs10.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.fasttrackit.curs10.mongo.model.entity.RoomEntity;

import java.util.List;

public interface RoomRepository extends MongoRepository<RoomEntity, String> {

    List<RoomEntity> findByRoomNumber(String roomNumber);
}
