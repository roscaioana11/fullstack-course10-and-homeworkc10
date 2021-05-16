package fasttrackit.ro.trainappmongodb.service.trains;

import fasttrackit.ro.trainappmongodb.exception.ValidationException;
import fasttrackit.ro.trainappmongodb.repository.trains.TrainsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.empty;

@Component
@RequiredArgsConstructor
public class TrainsValidator {
    private final TrainsRepository repository;

    private Optional<ValidationException> exists(String trainId) {
        return repository.existsById(trainId)
                ? empty()
                : Optional.of(new ValidationException(List.of("Train with id " + trainId + " doesn't exist")));
    }

    public void validateExistsOrThrow(String trainId) {
        exists(trainId).ifPresent(ex -> {
            throw ex;
        });
    }
}
