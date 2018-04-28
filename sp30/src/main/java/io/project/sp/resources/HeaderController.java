package io.project.sp.resources;

import io.project.sp.mongo.domain.Life;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import io.project.sp.mongo.repositories.LifeRepository;

/**
 *
 * @author armdev
 */
@RestController
@RequestMapping(path = "/api/v2/headers", produces = MediaType.APPLICATION_JSON_VALUE)
public class HeaderController {

    @Autowired
    private LifeRepository lifeRepository;

    @GetMapping(path = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Flux<?>> getLive(@PathVariable String name, @RequestHeader(value = "User-Agent") String userAgent) {

        System.out.println("User agent is " + userAgent);
        Flux<Life> life = lifeRepository.findByName(name);
        if (life != null) {
            System.out.println("life " + life.log().toString());
            return new ResponseEntity<>(life, HttpStatus.OK);
        }
        System.out.println("life ???");
        return new ResponseEntity<>(Flux.just("Error"), HttpStatus.NOT_FOUND);

    }

}
