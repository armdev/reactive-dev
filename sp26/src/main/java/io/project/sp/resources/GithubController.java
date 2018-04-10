package io.project.sp.resources;

import io.project.sp.httpclients.GithubClient;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(path = "/api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class GithubController {
    
    @Autowired
    private GithubClient gitHubClient;

    @GetMapping(path = "/repos", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<String> get() {              
        return gitHubClient.getRepositories();
    }   
    
}
