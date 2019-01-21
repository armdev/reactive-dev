package io.project.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 *
 * @author armena
 */
@RestController
@RequestMapping("/api/v2/users")
@Slf4j
public class ReactiveController {

    
    @GetMapping
    public Mono<String> find(@RequestParam String name) {
        log.info("We are loving coding in production mode!");
        return Mono.just("Hello " + name + " I hope I am reactive application!!!!!");
    }

    @GetMapping("/user")
    public ResponseEntity<Mono<?>> get() {        
        log.info("This is a GET request from you");
        return new ResponseEntity<>(Mono.just("One User here"), HttpStatus.I_AM_A_TEAPOT);
    }

    @GetMapping("/user/second")
    public Mono<ResponseEntity<?>> load() {
        log.info("Load me reactive client!");
        return Mono.just(ResponseEntity.ok().body("Second user location here"));
    }

}


// call me  http://localhost:8585/api/v2/users/?name=Yerevan