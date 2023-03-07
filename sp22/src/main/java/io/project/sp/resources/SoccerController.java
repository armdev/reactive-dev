package io.project.sp.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 *
 * @author armdev
 */
@RestController
@RequestMapping("/api/v2/teams")
public class SoccerController {

    @GetMapping(path = "/century/best")
    public Flux<String> getTheBestTeamInTheWorld(@RequestParam Integer year) {
        int century = this.getCenturyFromYear(year);
        if (century > 20) {
            return Flux.just("Real Madrid");
        }
        return Flux.just("Ararat(Yerevan)");
    }

    private int getCenturyFromYear(int year) {
        if (year % 100 == 0) {
            year = year / 100;
        } else {
            year = (year / 100) + 1;
        }
        return year;
    }

}
