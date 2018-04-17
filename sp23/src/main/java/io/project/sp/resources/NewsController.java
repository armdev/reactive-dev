package io.project.sp.resources;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author armdev
 */
@RestController
@RequestMapping(path="/api/v1/news", produces = MediaType.APPLICATION_JSON_VALUE)
public class NewsController {

    @GetMapping(path = "/top", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<String> getTopNews() {
        return Flux.just("Mr. Zuckerberg goes to Washington — so let’s stop acting like he can’t handle it. He can.",
                "Facing trade war with the U.S., China’s Xi vows to open auto industry", 
                "Here’s why owning a bike-share service makes sense for Uber");
    }

    @GetMapping("/latest")
    public Mono<String> getLatestNews() {
        return Mono.just("The latest international news from Sky, featuring top stories from around the world and breaking news, as it happens.");
    }

    @GetMapping("/local")
    public Mono<String> getLocalNews() {
        return Mono.just("Real Madrid back among Champions League favourites - Marca");
    }

}
