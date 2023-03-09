/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.sp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.web.reactive.function.BodyInserters.fromValue;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;

import org.springframework.web.reactive.function.server.RouterFunction;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 *
 * @author armdev
 */
@Configuration
public class RouteConfig {

    @Bean
    RouterFunction<ServerResponse> alohaRoute() {
        return route(path("/api/secrets/aloha"), req -> ok().build());
    }

    @Bean
    RouterFunction<ServerResponse> holaRoute() {
        return route(path("/api/secrets/hola"), req -> ok().body(fromValue("Did not find any secrets")));
    }
    
    //http://localhost:10006/api/secrets/hola

}
