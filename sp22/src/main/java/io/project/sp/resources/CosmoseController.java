package io.project.sp.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/cosmos")
public class CosmoseController {

    @GetMapping(path = "/generate")
    public Flux<String> get() {
        return Flux.just("Cosmose size is too big");
    }

}
