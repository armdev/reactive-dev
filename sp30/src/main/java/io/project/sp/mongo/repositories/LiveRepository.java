package io.project.sp.mongo.repositories;

import io.project.sp.mongo.domain.Live;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

/**
 *
 * @author armdev
 */

@Component
public interface LiveRepository extends ReactiveMongoRepository<Live, String>{
    
     Flux<Live> findByName(String name);
     boolean deleteByName(String name);
   
}
