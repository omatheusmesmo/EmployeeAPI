package com.omatheusmesmo.EmployeeAPI;

/**
 * The main application entry point for the Employee API.
 * This class is annotated with @SpringBootApplication to enable Spring Boot auto-configuration and component scanning.
 */
@SpringBootApplication
public class EmployeeApiApplication {

    /**
     * The main method, which runs the application using SpringApplication.run().
     *
     * @param args Command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        // Run the application
        SpringApplication.run(EmployeeApiApplication.class, args);
    }
}