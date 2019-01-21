/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app;

import lombok.extern.slf4j.Slf4j;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.HandlerFilterFunction;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 *
 * @author armena
 */
@Component
@Slf4j
public class RestHandlerFilterFunction implements HandlerFilterFunction<ServerResponse, ServerResponse> {

    @Override
    public Mono<ServerResponse> filter(ServerRequest serverRequest,
            HandlerFunction<ServerResponse> handlerFunction) {
        
        log.info("Super handler is working");
        
//        if (serverRequest.pathVariable("name").equalsIgnoreCase("test")) {
//            return ServerResponse.status(FORBIDDEN).build();
//        }
        return handlerFunction.handle(serverRequest);
    }

}
