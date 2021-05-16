package fasttrackit.ro.trainappmongodb.controller;

import com.github.fge.jsonpatch.JsonPatch;
import fasttrackit.ro.trainappmongodb.model.TrainFilter;
import fasttrackit.ro.trainappmongodb.model.entity.TrainsEntity;
import fasttrackit.ro.trainappmongodb.service.trains.TrainsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("locations/{locationsId}/trains")
@RequiredArgsConstructor
public class TrainsController {
    private final TrainsService trainsService;

    @GetMapping
    List<TrainsEntity> getFilteredTrains(TrainFilter filter){
        return trainsService.getFilteredTrains(filter);
    }

    @PostMapping
    TrainsEntity addTrain(@RequestBody TrainsEntity train,
                          @PathVariable String locationsId) {
        return trainsService.addTrain(train, locationsId);
    }

    @PatchMapping(path = "/{trainId}")
    TrainsEntity patchTrain(@RequestBody JsonPatch patch,
                           @PathVariable("trainId") String trainId){
        return trainsService.patchTrain(trainId, patch);
    }

    @DeleteMapping("{trainId}")
    void deleteTrain(@PathVariable String trainId){
        trainsService.deleteTrain(trainId);
    }
}
