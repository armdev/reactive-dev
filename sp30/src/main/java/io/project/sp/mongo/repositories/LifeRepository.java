package io.project.sp.mongo.repositories;

import io.project.sp.mongo.domain.Life;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

/**
 *
 * @author armdev
 */

@Component
public interface LifeRepository extends ReactiveMongoRepository<Life, String>{
    
     Flux<Life> findByName(String name);
  
   
}
