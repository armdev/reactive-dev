package io.project.sp;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 *
 * @author armdev
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableReactiveMongoRepositories("io.project.sp.mongo.repositories")
@ComponentScan("io.project")
public class Sp28Application {

    public static void main(String[] args) {
        final SpringApplication application = new SpringApplication(Sp28Application.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.setWebApplicationType(WebApplicationType.REACTIVE);
        application.run(args);
    }
}
