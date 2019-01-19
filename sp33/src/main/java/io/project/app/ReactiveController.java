package io.project.app;

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
public class ReactiveController {

    // http://localhost:8585/api/v2/users/?name=Yerevan
    @GetMapping
    public Mono<String> find(@RequestParam String name) {
        return Mono.just("Hello " + name);
    }

    @GetMapping("/user")
    public ResponseEntity<Mono<?>> get() {
        return new ResponseEntity<>(Mono.just("One User here"), HttpStatus.I_AM_A_TEAPOT);
    }

    @GetMapping("/user/second")
    public Mono<ResponseEntity<?>> load() {
        return Mono.just(ResponseEntity.ok().body("Second user here"));
    }

}
