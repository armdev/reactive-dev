/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
