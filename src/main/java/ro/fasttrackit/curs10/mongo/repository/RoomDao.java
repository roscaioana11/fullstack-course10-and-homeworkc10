package ro.fasttrackit.curs10.mongo.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.curs10.mongo.model.entity.RoomEntity;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RoomDao {
    private final MongoTemplate mongo;

    public Page<RoomEntity> findRooms() {
        Criteria criteria = Criteria.where("roomNumber").regex(".*A.*");

        Query query = Query.query(criteria);
        PageRequest pageable = PageRequest.of(0, 2, Sort.by("roomNumber"));
        query.with(pageable);
        List<RoomEntity> rooms = mongo.find(
                query,
                RoomEntity.class);
        return PageableExecutionUtils.getPage(
                rooms,
                pageable,
                () -> mongo.count(Query.query(criteria), RoomEntity.class));
    }
}
