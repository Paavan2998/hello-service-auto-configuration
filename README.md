# hello-service-auto-configuration

This application was generated to understand the working of auto configuration in spring boot application. 

## Modules

1. hello-app : Main application that will leverage the concept of auto configuration. It uses hello-service to print out a greeting message.

2. hello-service : It contains the implementation for greeting.

3. hello-starter : It creates a bean of HelloService that is used by hello-app. It creates a bean only if the arguments passed to create the bean are valid.


### Learnings (TODO: create a HTML page of learnings and put the reference to the link below)

#### 1. Spring Events when application starts up. (This is when the run method is executed)
1. ApplicationStartedEvent : It initializes Logging system.
2. ApplicationEnvironmentPreparedEvent : It means that the environment is been created and containes the default set of property sources. 
	* At this point application context is not created and neither the beans are created.
	* The config files(application.properties) are read. 
	* Environment post processor are called.
	* Logging initialization completes
3. ApplicationPreparedEvent : 
	* Application context is refreshed.
4. ContextRefreshedEvent : 
	* Embedded servlet container connectors are started. The embedded servlet is a bean but the servlet connectors which exposes the port and allows to make http request are not started until ContextRefreshedEvent is registered. This is done to avoid exposing the url before the application is fully initialized.
5. EmbeddedServletContainerInitializedEvent : 
	* After this event a developer can register a servlet or a filter programmatically in the servlet container using the ServletContext provided by the EmbeddedServletContainerInitializedEvent.
6. ApplicationReadyEvent : The application has fully started.