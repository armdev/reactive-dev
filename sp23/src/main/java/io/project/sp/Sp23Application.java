package io.project.sp;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class Sp23Application {

  
    public static void main(String[] args) {
        final SpringApplication application = new SpringApplication(Sp23Application.class);
        application.setBannerMode(Banner.Mode.CONSOLE);
        application.setWebApplicationType(WebApplicationType.REACTIVE);
        application.run(args);
    }
}
