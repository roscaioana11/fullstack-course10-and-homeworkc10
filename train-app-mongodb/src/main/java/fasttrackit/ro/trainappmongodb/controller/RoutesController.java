package fasttrackit.ro.trainappmongodb.controller;

import fasttrackit.ro.trainappmongodb.model.entity.RoutesEntity;
import fasttrackit.ro.trainappmongodb.service.routes.RoutesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("routes")
@RequiredArgsConstructor
public class RoutesController {
    private final RoutesService routesService;

    @PostMapping
    RoutesEntity createRoute(@RequestBody RoutesEntity route){
        return routesService.createRoute(route);
    }
}
