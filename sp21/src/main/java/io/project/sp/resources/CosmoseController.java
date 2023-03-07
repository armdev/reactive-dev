/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.sp.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 *
 * @author armdev
 */
@RestController
@RequestMapping("/api/cosmos")
public class CosmoseController {

    @GetMapping(path = "/generate")
    public Flux<String> get() {
        return Flux.just("Cosmose size is too big");
    }

}
