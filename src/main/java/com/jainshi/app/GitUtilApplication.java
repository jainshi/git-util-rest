package com.jainshi.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class GitUtilApplication {
    public static void main( String[] args ) {
        SpringApplication.run(GitUtilApplication.class, args);
    }
}
