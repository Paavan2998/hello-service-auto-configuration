package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @SpringBootApplication is meta annotated with three different annotations: @SpringBootConfiguration, @ComponentScan, @EnableAutoConfiguration
 * @ComponentScan: If any class is annotated with @Component annotation it will be picked up in component scan. This will register all the beans that user has specified and then autoconfiguration runs.
 * @EnableAutoConfiguration: This will add additional beans that are required to run the dependencies we have added*/
@SpringBootApplication
public class HelloApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder(HelloApp.class)
                .listeners(new HelloApplicationListener())
                .run(args);
    }
}