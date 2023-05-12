package org.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class HelloCommandLineRunner implements CommandLineRunner {
    private final HelloService service;
    /**
     * The constructor needs a parameter of type HelloService. One way to that is instantiate the class using this
     * constructor or make a bean of HelloService. If there is a bean of type HelloService it will automatically
     * take it and use it to instantiate the HelloCommandLineRunner class.*/
    public HelloCommandLineRunner(HelloService service){
        this.service = service;
    }
    @Override
    public void run(String... args) throws Exception {
        this.service.sayHello("World");
    }
}
