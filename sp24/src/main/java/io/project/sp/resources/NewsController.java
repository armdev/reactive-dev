package io.project.sp.resources;

import lombok.extern.slf4j.Slf4j;
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
@RequestMapping(path = "/api/v2/news", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class NewsController {

    @GetMapping(path = "/top", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> getTopNews(ServerHttpRequest request) {

        log.info("**************************************************************");        
        log.info("User-Agent: " + request.getHeaders().get("User-Agent"));
        log.info("content-type: " + request.getHeaders().get("content-type"));
        log.info("Accept-Encoding: " + request.getHeaders().get("Accept-Encoding"));
        log.info("x-forwarded-host: " + request.getHeaders().get("x-forwarded-host"));
        log.info("x-forwarded-proto: " + request.getHeaders().get("x-forwarded-proto"));
        log.info("x-forwarded-prefix: " + request.getHeaders().get("x-forwarded-prefix"));
        log.info("x-forwarded-port: " + request.getHeaders().get("x-forwarded-port"));
        log.info("x-forwarded-for: " + request.getHeaders().get("x-forwarded-for"));
        log.info("Content-Length: " + request.getHeaders().get("Content-Length"));
        log.info("Host: " + request.getHeaders().get("Host"));
        
        String message = "Dear ->  "+  request.getHeaders().get("User-Agent").get(0) + " <- our service could not find any top news for you!!!";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Mono.just(message));
    }
}
