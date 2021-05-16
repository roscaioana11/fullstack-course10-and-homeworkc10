package fasttrackit.ro.trainappmongodb.repository;

import fasttrackit.ro.trainappmongodb.model.entity.RoutesEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutesRepository extends MongoRepository<RoutesEntity, String> {
}
