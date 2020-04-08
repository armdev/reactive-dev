/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app;

import lombok.extern.slf4j.Slf4j;
import static org.springframework.http.HttpStatus.FORBIDDEN;
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
        log.info("REQUEST PATH IS WORKING " + swe.getRequest().getPath().toString());
        log.info("HEADERS IS WORKING " + swe.getRequest().getHeaders().toString());
        String get = swe.getRequest().getHeaders().get("User-agent").get(0);
        if (get != null) {
            if (get.contains("curl")) {
                log.error("Some one call me from console?");
                swe.getResponse().setStatusCode(FORBIDDEN);
                swe.getResponse().setComplete();
                log.error("Just enjoy my response");
            }

        }

        swe.getResponse()
                .getHeaders().add("web-filter", "web-filter-test");
        return wfc.filter(swe);

    }

}
