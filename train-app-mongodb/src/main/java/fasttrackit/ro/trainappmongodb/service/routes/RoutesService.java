package fasttrackit.ro.trainappmongodb.service.routes;

import fasttrackit.ro.trainappmongodb.model.entity.RoutesEntity;
import fasttrackit.ro.trainappmongodb.model.entity.TrainsEntity;
import fasttrackit.ro.trainappmongodb.repository.RoutesRepository;
import fasttrackit.ro.trainappmongodb.service.locations.LocationsValidator;
import fasttrackit.ro.trainappmongodb.service.trains.TrainsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoutesService {
    private final RoutesRepository routesRepository;
    private final TrainsService trainsService;
    private final LocationsValidator locationsValidator;

    public RoutesEntity createRoute(RoutesEntity route){
        locationsValidator.validateExistsOrThrow(route.getStart());
        locationsValidator.validateExistsOrThrow(route.getDestination());
        TrainsEntity foundTrain = trainsService.getTrainById(route.getTrainId());
        if(route.getStart().equals(foundTrain.getLocationId())){
            return routesRepository.save(route);
        }else {
            throw new RuntimeException("Train Location is not the same as Routes starting Location!");
        }
    }
}
