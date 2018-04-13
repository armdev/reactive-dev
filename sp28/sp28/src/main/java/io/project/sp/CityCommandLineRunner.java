/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.sp;

import io.project.sp.mongo.domain.City;
import io.project.sp.mongo.repositories.CityRepository;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author armdev
 */
@Component
public class CityCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public void run(String... args) throws Exception {
        List<City> citiesList = Arrays.asList(
                new City("New York", 8491079),
                new City("Los Angeles", 3947476),
                new City("Chicago", 2722389),
                new City("Yerevan", 1000000)
        );

        this.cityRepository.insert(citiesList).blockLast(Duration.ofSeconds(3));
    }

}
