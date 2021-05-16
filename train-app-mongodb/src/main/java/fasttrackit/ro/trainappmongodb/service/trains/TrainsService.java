package fasttrackit.ro.trainappmongodb.service.trains;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import fasttrackit.ro.trainappmongodb.exception.ResourceNotFoundException;
import fasttrackit.ro.trainappmongodb.model.TrainFilter;
import fasttrackit.ro.trainappmongodb.model.entity.TrainsEntity;
import fasttrackit.ro.trainappmongodb.repository.trains.TrainDao;
import fasttrackit.ro.trainappmongodb.repository.trains.TrainsRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainsService {
    private final TrainsRepository trainsRepository;
    private final TrainsValidator validator;
    private final TrainDao dao;
    private final ObjectMapper mapper;

    public List<TrainsEntity> getFilteredTrains(TrainFilter filter){
        return dao.getAll(filter);
    }

    public TrainsEntity getTrainById(String trainId){
        validator.validateExistsOrThrow(trainId);
        return trainsRepository.findById(trainId)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find train with id " + trainId));
    }

    public TrainsEntity addTrain(TrainsEntity train, String locationId) {
        train.setLocationId(locationId);
        return trainsRepository.save(train);
    }

    @SneakyThrows
    public TrainsEntity patchTrain(String trainId, JsonPatch patch){
        validator.validateExistsOrThrow(trainId);
        TrainsEntity dbTrain = trainsRepository.findById(trainId)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find train with id " + trainId));

        JsonNode patchedTrainJson = patch.apply(mapper.valueToTree(dbTrain));
        TrainsEntity patchedTrain = mapper.treeToValue(patchedTrainJson, TrainsEntity.class);
        return trainsRepository.save(patchedTrain);
    }

    public void deleteTrain(String trainId){
        validator.validateExistsOrThrow(trainId);
        trainsRepository.deleteById(trainId);
    }
}
