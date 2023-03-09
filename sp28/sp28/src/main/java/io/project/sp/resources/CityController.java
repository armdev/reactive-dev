package io.project.sp.resources;

import io.project.sp.mongo.domain.City;
import io.project.sp.mongo.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 *
 * @author armdev
 */
@RestController
@RequestMapping(path = "/api/v1/cities")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<City> get() {
        return cityRepository.findAll();
    }

}
