/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 *
 * @author armena
 */
@Component
@Slf4j
public class RestWebFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange swe, WebFilterChain wfc) {
     log.info("RestWebFilter is working now");
        swe.getResponse()
                .getHeaders().add("web-filter", "web-filter-test");
        return wfc.filter(swe);

    }

}
