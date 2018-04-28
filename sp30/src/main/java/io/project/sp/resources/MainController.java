package io.project.sp.resources;

import io.project.sp.mongo.domain.City;
import io.project.sp.mongo.repositories.CityRepository;
import java.io.FileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 *
 * @author armdev
 */
@RestController
@RequestMapping(path = "/api/v2/search", produces = MediaType.APPLICATION_JSON_VALUE)
public class MainController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping(path = "/city/{cityName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<City> get(@PathVariable String cityName) {
        System.out.println("@name is " + cityName);
        return cityRepository.findByName(cityName);
    }

    @RequestMapping(value = "*", method = RequestMethod.GET)
    @ResponseBody
    public String getFallback() {
        return "Fallback for GET Requests";
    }

    @RequestMapping(value = "/fail", method = RequestMethod.GET)
    @ResponseBody
    public void someFail() {
        throw new RuntimeException("Some error");
    }

}
