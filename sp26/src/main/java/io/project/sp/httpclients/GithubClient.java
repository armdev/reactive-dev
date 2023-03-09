package io.project.sp.httpclients;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

/**
 *
 * @author armdev
 */
@Service
@Component
public class GithubClient {

    public Flux<String> getRepositories() {
        WebClient client = WebClient.create("https://api.github.com/users");
        return client
                .get()
                .uri("/armdev/repos")
                .exchange()
                .flatMapMany(res -> res.bodyToFlux(String.class));
        //.log().toString();
    }

}
