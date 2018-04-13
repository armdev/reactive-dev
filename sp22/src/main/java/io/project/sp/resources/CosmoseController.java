package io.project.sp.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author armdev
 */
@RestController
public class CosmoseController {
    
    @GetMapping
    public String getCosmoseSize(){
        return "Cosmose size is too big";
    }
    
}
