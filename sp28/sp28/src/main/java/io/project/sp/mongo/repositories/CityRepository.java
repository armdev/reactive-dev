/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.sp.mongo.repositories;

import io.project.sp.mongo.domain.City;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public interface CityRepository extends ReactiveMongoRepository<City, String>{
    
     Flux<City> findByName(String name);
     Mono<City> findByPopulation(Integer population);
}
