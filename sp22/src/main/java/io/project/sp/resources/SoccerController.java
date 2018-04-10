package io.project.sp.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author armdev
 */
@RestController
@RequestMapping("/api/v1/teams")
public class SoccerController {

    @GetMapping("/best")
    public String getTheBestTeamInTheWorld() {
        int century = this.getCenturyFromYear(2018);
        if (century > 19) {
            return "Real Madrid !!!";
        }
        return "Real Madrid !";
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
