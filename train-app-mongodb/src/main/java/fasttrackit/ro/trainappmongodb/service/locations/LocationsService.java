package fasttrackit.ro.trainappmongodb.service.locations;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import fasttrackit.ro.trainappmongodb.exception.ResourceNotFoundException;
import fasttrackit.ro.trainappmongodb.model.entity.LocationsEntity;
import fasttrackit.ro.trainappmongodb.repository.LocationsRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationsService {
    private final LocationsRepository locationsRepository;
    private final LocationsValidator locationsValidator;
    private final ObjectMapper mapper;

    public LocationsEntity createLocation(LocationsEntity location) {
        return locationsRepository.save(location);
    }

    @SneakyThrows
    public LocationsEntity patchLocation(String locationId, JsonPatch patch){
        locationsValidator.validateExistsOrThrow(locationId);
        LocationsEntity dbLocation = locationsRepository.findById(locationId)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find location with id " + locationId));

        JsonNode patchedLocationJson = patch.apply(mapper.valueToTree(dbLocation));
        LocationsEntity patchedLocation = mapper.treeToValue(patchedLocationJson, LocationsEntity.class);
        return locationsRepository.save(patchedLocation);
    }

    public void deleteLocation(String locationId){
        locationsValidator.validateExistsOrThrow(locationId);
        locationsRepository.deleteById(locationId);
    }
}
