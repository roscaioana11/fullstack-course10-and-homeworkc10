package fasttrackit.ro.trainappmongodb.repository.trains;

import fasttrackit.ro.trainappmongodb.model.TrainFilter;
import fasttrackit.ro.trainappmongodb.model.entity.TrainsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static java.util.Optional.ofNullable;

@Repository
@RequiredArgsConstructor
public class TrainDao {
    private final MongoTemplate mongo;

    public List<TrainsEntity> getAll(TrainFilter filters) {

        Criteria criteria = new Criteria();

        ofNullable(filters.getLocation())
                .ifPresent(location -> criteria.and("locationId").is(location));
        ofNullable(filters.getModel())
                .ifPresent(model -> criteria.and("model").is(model));
        ofNullable(filters.getMinCart())
                .ifPresent(minCart -> criteria.and("carts").gte(minCart)); //gte - greater than or equal - >=
        ofNullable(filters.getMaxCart())
                .ifPresent(maxCart -> criteria.and("carts").lte(maxCart)); //lte - less than or equal - <=

        Query query = Query.query(criteria);
        return mongo.find(query, TrainsEntity.class);
    }
}
