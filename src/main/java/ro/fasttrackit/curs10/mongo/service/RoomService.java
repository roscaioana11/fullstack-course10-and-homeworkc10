package ro.fasttrackit.curs10.mongo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.curs10.mongo.model.entity.RoomEntity;
import ro.fasttrackit.curs10.mongo.repository.RoomRepository;

import java.util.List;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    public List<RoomEntity> getAll(String number) {
        return ofNullable(number)
                .map(roomRepository::findByRoomNumber)
                .orElseGet(roomRepository::findAll);
    }

    public RoomEntity addRoom(RoomEntity room) {
        return roomRepository.save(room);
    }
}
