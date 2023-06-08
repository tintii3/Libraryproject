package com.example.libraryproject.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.libraryproject")
public class LibraryprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryprojectApplication.class, args);
    }

}
