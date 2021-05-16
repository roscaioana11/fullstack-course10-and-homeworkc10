package fasttrackit.ro.trainappmongodb.service.locations;

import fasttrackit.ro.trainappmongodb.exception.ValidationException;
import fasttrackit.ro.trainappmongodb.repository.LocationsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.empty;

@Component
@RequiredArgsConstructor
public class LocationsValidator {
    private final LocationsRepository repository;

    private Optional<ValidationException> exists(String locationId) {
        return repository.existsById(locationId)
                ? empty()
                : Optional.of(new ValidationException(List.of("Location with id " + locationId + " doesn't exist")));
    }

    public void validateExistsOrThrow(String locationId) {
        exists(locationId).ifPresent(ex -> {
            throw ex;
        });
    }
}
