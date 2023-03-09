package io.project.sp.resources;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
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
@RequestMapping(path = "/api/v2/data")
public class MainController {

    private final Random random = new Random();

    private final List<Double> prices = new ArrayList<>();

    @GetMapping(path = "/gen", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Double> get() {
        return fetchStream(Duration.ofSeconds(1));
    }

    public Flux<Double> fetchStream(Duration period) {

        return Flux.interval(period)
                // In case of back-pressure, drop events
                .onBackpressureDrop()
                // For each tick, generate a list of quotes
                .map(this::generateData)
                .flatMapIterable(q -> q)
                .log("Generating data");
    }

    private List<Double> generateData(long interval) {

        return prices.stream().map(b -> this.random.nextDouble()).collect(Collectors.toList());

    }

}
