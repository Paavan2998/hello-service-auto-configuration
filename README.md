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

#### 2. Autoconfiguration in Spring Boot.
1. @SpringBootApplication is meta annotated with three different annotations: @SpringBootConfiguration, @ComponentScan, @EnableAutoConfiguration. 
   * @ComponentScan: If any class is annotated with @Component annotation it will be picked up in component scan. This will register all the beans that user has specified and then autoconfiguration runs. 
   * @EnableAutoConfiguration: This will add additional beans that are required to run the application. These beans will be created only if bean with the same name is missing. So if we have created our own implementation for a bean it will use that instead of its own implementation.
2. spring.factories file.
   * The Spring Factories file is a special file named META-INF/spring.factories that is used by Spring Framework to autoconfigure applications. It is a file that contains a list of classes that should be automatically configured when the application starts up. 
   * The Spring Framework scans the classpath at startup looking for this file, and then reads the contents of the file to find the classes that should be autoconfigured. Once it has found these classes, it instantiates them and configures them automatically. 
   * For example, the spring-boot-autoconfigure project uses the spring.factories file to autoconfigure different components such as security, logging, web, etc. when it's included as a dependency in a Spring Boot application.

#### 3. Creating own beans with custom validation and annotation.

#### 4. Failure Analyzer Demonstration used to give precise and crisp message to user instead of the whole stack trace.



