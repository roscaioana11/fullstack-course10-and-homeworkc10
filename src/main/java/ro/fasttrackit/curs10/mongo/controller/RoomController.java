package ro.fasttrackit.curs10.mongo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.curs10.mongo.model.api.Room;
import ro.fasttrackit.curs10.mongo.model.mappers.RoomMapper;
import ro.fasttrackit.curs10.mongo.service.RoomService;

import java.util.List;

@RestController
@RequestMapping("rooms")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService service;
    private final RoomMapper mapper;

    @GetMapping
    List<Room> getAll(@RequestParam(required = false) String number) {
        return mapper.toApi(
                service.getAll(number));
    }

    @PostMapping
    Room addRoom(@RequestBody Room room) {
        return mapper.toApi(
                service.addRoom(mapper.toEntity(room)));
    }

}
