package io.project.sp.resources;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

/**
 *
 * @author armdev
 */
@RestController
@RequestMapping(path = "/api/v1/news", produces = MediaType.APPLICATION_JSON_VALUE)
public class NewsController {

    @GetMapping(path = "/sse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> sse() {
        List<String> data = new ArrayList<>(Arrays.asList("{A}", "{B}", "{C}"));
        Flux<String> intervalFlux2 = Flux.interval(Duration.ofMillis(1000))
                .zipWithIterable(data)
                .map(source -> "item " + source.getT1() + ": " + source.getT2());

        return intervalFlux2.repeat();
    }

    @GetMapping(path = "/sse/hot", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> sseHot() {
        ArrayList<Integer> arrayRandom = new ArrayList<>(10);
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        for (int i = 0; i < 10; i++) {
            Integer r = rand.nextInt() % 256;
            arrayRandom.add(r);
        }

        Flux<String> intervalFlux2 = Flux.interval(Duration.ofMillis(1000))
                .zipWithIterable(arrayRandom)
                .map(source -> "item " + source.getT1() + ": " + source.getT2());

        return intervalFlux2.repeat();
    }

    // https://projectreactor.io/docs/core/release/api/reactor/util/function/Tuple2.html
}
