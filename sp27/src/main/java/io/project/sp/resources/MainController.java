package io.project.sp.resources;

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
@RequestMapping(path = "/api/v2/accounts")
public class MainController {

    @GetMapping(path = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<String> get() {
        return Flux.just("Aloha", "Hola", "Barev");
    }

}
