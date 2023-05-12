package org.example;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class HelloApplicationListener implements ApplicationListener<ApplicationEvent> {
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("Received --> " + applicationEvent.getClass().getName());
    }

    /**
     * We want to register this class to make sure that it gets picked up by the application
     * so that we can catch the application event.
     *
     * First approach that comes to mind is to annotate the class with @Component annotation.
     * But if we did most of the events will be missed because all the events that will be
     * fired before application context is actually refreshed. And it can happen that When this
     * event is fired this bean is not there.
     *
     * To register this class we will use spring application builder it is a way to custom the
     * application before it starts.*/
}
