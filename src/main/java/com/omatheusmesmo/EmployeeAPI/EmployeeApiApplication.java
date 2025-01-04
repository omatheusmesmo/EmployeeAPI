package com.omatheusmesmo.EmployeeAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main application class for the Employee API.
 */
@SpringBootApplication
public class EmployeeApiApplication {

    /**
     * Entry point for the application. Runs the SpringApplication instance with the provided arguments.
     *
     * @param args Command line arguments passed to the application.
     */
    public static void main(String[] args) {
        SpringApplication.run(EmployeeApiApplication.class, args);
    }

}