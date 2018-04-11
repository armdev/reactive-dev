/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.sp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;

import org.springframework.web.reactive.function.server.RouterFunction;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 *
 * @author armena
 */
@Configuration
public class RouteConfig {

    
    @Bean
    RouterFunction<ServerResponse> alohaRoute() {
        return route(path("/api/v2/secrets/aloha"), req -> ok().build());
    }
    
    
    @Bean
    RouterFunction<ServerResponse> holaRoute() {
        return route(path("/api/v2/secrets/hola"), req -> ok().body(fromObject("Did not find any secrets")));
    }


}
