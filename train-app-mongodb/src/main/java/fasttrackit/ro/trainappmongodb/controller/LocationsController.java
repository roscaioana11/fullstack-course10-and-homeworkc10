package fasttrackit.ro.trainappmongodb.controller;

import com.github.fge.jsonpatch.JsonPatch;
import fasttrackit.ro.trainappmongodb.model.entity.LocationsEntity;
import fasttrackit.ro.trainappmongodb.service.locations.LocationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("locations")
@RequiredArgsConstructor
public class LocationsController {
    private final LocationsService locationsService;

    @PostMapping
    LocationsEntity createLocation(@RequestBody LocationsEntity location){
        return locationsService.createLocation(location);
    }

    @PatchMapping("/{locationId}")
    LocationsEntity patchLocation(@RequestBody JsonPatch patch,
                                  @PathVariable("locationId") String locationId){
        return locationsService.patchLocation(locationId, patch);
    }

    @DeleteMapping("/{locationId}")
    void deleteLocation(@PathVariable String locationId){
        locationsService.deleteLocation(locationId);
    }
}
