package io.project.sp.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 *
 * @author armdev
 */
@RestController
@RequestMapping(path = "/api/v1/news", produces = MediaType.APPLICATION_JSON_VALUE)
public class NewsController {

    @GetMapping(path = "/top", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> getTopNews(ServerHttpRequest request) {

        System.out.println("**************************************************************");        
        System.out.println("User-Agent: " + request.getHeaders().get("User-Agent"));
        System.out.println("content-type: " + request.getHeaders().get("content-type"));
        System.out.println("Accept-Encoding: " + request.getHeaders().get("Accept-Encoding"));
        System.out.println("x-forwarded-host: " + request.getHeaders().get("x-forwarded-host"));
        System.out.println("x-forwarded-proto: " + request.getHeaders().get("x-forwarded-proto"));
        System.out.println("x-forwarded-prefix: " + request.getHeaders().get("x-forwarded-prefix"));
        System.out.println("x-forwarded-port: " + request.getHeaders().get("x-forwarded-port"));
        System.out.println("x-forwarded-for: " + request.getHeaders().get("x-forwarded-for"));
        System.out.println("Content-Length: " + request.getHeaders().get("Content-Length"));
        System.out.println("Host: " + request.getHeaders().get("Host"));
        
        String message = "Dear ->  "+  request.getHeaders().get("User-Agent").get(0) + " <- our service could not find any top news for you!!!";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Mono.just(message));
    }
}
