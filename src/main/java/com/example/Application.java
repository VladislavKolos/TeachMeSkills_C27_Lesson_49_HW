package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main application class that runs the "Spring Boot" application.
 */
@SpringBootApplication
public class Application {

    /**
     * The "main" method that serves as the entry point to launch a "Spring Boot" application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
