package fasttrackit.ro.trainappmongodb.repository;

import fasttrackit.ro.trainappmongodb.model.entity.LocationsEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationsRepository extends MongoRepository<LocationsEntity, String> {
}
