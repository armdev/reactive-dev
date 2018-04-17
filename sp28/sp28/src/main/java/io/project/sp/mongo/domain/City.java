/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.sp.mongo.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author armdev
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Document(collection = "city")
public class City implements Serializable{

    private static final long serialVersionUID = 5803757207294029907L;
    
    @Id
    private String id;
    
    @TextIndexed
    private String name;
    private Integer population;

    public City(String name, Integer population) {
        this.name = name;
        this.population = population;        
    }
    
    
}
