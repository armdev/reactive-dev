package io.project.sp.resources;

import io.project.sp.domain.Agent;
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
@RequestMapping(path = "/api/v2/agents", produces = MediaType.APPLICATION_JSON_VALUE)
public class AgentController {
    
    
    @GetMapping("/message")
    private Flux<Agent> allMessages(){
        return Flux.just(
            Agent.builder().message("Tom Ferry 87% of All Agents Fail in Real Estate!").build(),
            Agent.builder().message("10 Reasons You Will Fail As A Real Estate Agent - Inman").build()
        );
    }
}
