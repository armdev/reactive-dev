package io.project.app;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sp33Application {
//
//	public static void main(String[] args) {
//		SpringApplication.run(Sp33Application.class, args);
//	}
//        

    public static void main(String[] args) {
        final SpringApplication application = new SpringApplication(Sp33Application.class);
        application.setBannerMode(Banner.Mode.CONSOLE);
        application.setWebApplicationType(WebApplicationType.REACTIVE);
        application.run(args);
    }

}
