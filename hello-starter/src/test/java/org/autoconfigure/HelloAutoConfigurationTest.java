package org.autoconfigure;

import org.example.ConsoleHelloService;
import org.example.HelloService;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import static org.junit.Assert.assertEquals;

public class HelloAutoConfigurationTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    private ConfigurableApplicationContext context;

    @After
    public void closeContext(){
        if(this.context != null){
            this.context.close();
        }
    }

    @Test
    public void defaultServiceAutoConfigured(){
        load(EmptyConfiguration.class,"Hello.prefix=Howdy");
        HelloService service = this.context.getBean(HelloService.class);
        String msg = service.sayHello("World");
        assertEquals("Howdy World!", msg);
    }

    @Test
    public void defaultServiceBacksOff(){
        load(UserConfiguration.class);
        HelloService service = this.context.getBean(HelloService.class);
        String msg = service.sayHello("Works");
        assertEquals("Mine Works**", msg);
    }
    private void load(Class<?> config, String... environment){
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext();
        ctx.register(config);
        TestPropertyValues.of(environment).applyTo(ctx);
        ctx.refresh();
        this.context = ctx;
    }
    @Configuration
    @ImportAutoConfiguration(HelloAutoConfiguration.class)
    static class EmptyConfiguration {
    }
    @Configuration
    @Import(EmptyConfiguration.class)
    static class UserConfiguration {
        @Bean
        public HelloService helloService(){
            return new ConsoleHelloService("Mine", "**");
        }
    }
}