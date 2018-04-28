package io.project.sp.resources;

import io.project.sp.mongo.domain.Live;
import io.project.sp.mongo.repositories.LiveRepository;
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

/**
 *
 * @author armdev
 */
@RestController
@RequestMapping(path = "/api/v2/live", produces = MediaType.APPLICATION_JSON_VALUE)
public class LiveController {

    @Autowired
    private LiveRepository liveRepository;

    @GetMapping("/all")
    public ResponseEntity<?> get(@PathVariable String name) {
        final Flux<Live> live = liveRepository.findAll();
        if (live != null) {
            return new ResponseEntity<>(live, HttpStatus.OK);
        }
        return new ResponseEntity<>(new Live(), HttpStatus.NOT_FOUND);

    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getLive(@PathVariable String name) {
        final Flux<Live> live = liveRepository.findByName(name);
        if (live != null) {
            return new ResponseEntity<>(live, HttpStatus.OK);
        }
        return new ResponseEntity<>(new Live(), HttpStatus.NOT_FOUND);

    }

    @PostMapping
    public ResponseEntity<?> newLive(@Valid @RequestBody Live live) {
        Mono<Live> savedLive = liveRepository.save(live);
        if (savedLive != null) {
            return new ResponseEntity<>(savedLive, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new Live(), HttpStatus.I_AM_A_TEAPOT);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<?> deleteLive(@PathVariable String name) {
        boolean delete = liveRepository.deleteByName(name);
        if (delete) {
            return new ResponseEntity<>("Record deleted", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Could not delete", HttpStatus.NOT_ACCEPTABLE);
    }

}
