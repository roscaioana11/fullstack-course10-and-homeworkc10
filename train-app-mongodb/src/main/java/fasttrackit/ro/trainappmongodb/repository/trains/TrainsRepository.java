package fasttrackit.ro.trainappmongodb.repository.trains;

import fasttrackit.ro.trainappmongodb.model.entity.TrainsEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainsRepository extends MongoRepository<TrainsEntity, String> {
}
