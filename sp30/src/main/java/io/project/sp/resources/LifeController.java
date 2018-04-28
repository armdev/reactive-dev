package io.project.sp.resources;

import io.project.sp.mongo.domain.Life;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import io.project.sp.mongo.repositories.LifeRepository;

/**
 *
 * @author armdev
 */
@RestController
@RequestMapping(path = "/api/v2/lifes", produces = MediaType.APPLICATION_JSON_VALUE)
public class LifeController {
    // http://www.baeldung.com/spring-requestmapping

    @Autowired
    private LifeRepository liveRepository;

    @GetMapping("/all")
    public ResponseEntity<Flux<?>> get() {
        final Flux<Life> life = liveRepository.findAll();
        if (life != null) {
            return new ResponseEntity<>(life, HttpStatus.OK);
        }
        return new ResponseEntity<>(Flux.just("Did not find"), HttpStatus.NOT_FOUND);

    }

    @GetMapping("/{name}")
    public ResponseEntity<Flux<?>> getLive(@PathVariable String name) {
        final Flux<Life> life = liveRepository.findByName(name);
        if (life != null) {
            return new ResponseEntity<>(life, HttpStatus.OK);
        }
        return new ResponseEntity<>(Flux.just("Did not find"), HttpStatus.NOT_FOUND);

    }

    @PostMapping
    public ResponseEntity<Mono<?>>  newLive(@Valid @RequestBody Life life) {
        Mono<Life> savedLive = liveRepository.save(life);
        if (savedLive != null) {
            return new ResponseEntity<>(savedLive, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(Mono.just(new Life()), HttpStatus.I_AM_A_TEAPOT);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<?> deleteLive(@PathVariable String name) {
//        boolean delete = liveRepository.deleteByName(name);
//        if (delete) {
//            return new ResponseEntity<>("Record deleted", HttpStatus.ACCEPTED);
//        }
        return new ResponseEntity<>("Could not delete", HttpStatus.NOT_ACCEPTABLE);
    }

}
