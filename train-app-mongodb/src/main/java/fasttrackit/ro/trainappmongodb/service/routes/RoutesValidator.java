package fasttrackit.ro.trainappmongodb.service.routes;

import fasttrackit.ro.trainappmongodb.exception.ValidationException;
import fasttrackit.ro.trainappmongodb.repository.RoutesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.empty;

@Component
@RequiredArgsConstructor
public class RoutesValidator {
    private final RoutesRepository repository;

    private Optional<ValidationException> exists(String routesId) {
        return repository.existsById(routesId)
                ? empty()
                : Optional.of(new ValidationException(List.of("Route with id " + routesId + " doesn't exist")));
    }

    public void validateExistsOrThrow(String routesId) {
        exists(routesId).ifPresent(ex -> {
            throw ex;
        });
    }
}
