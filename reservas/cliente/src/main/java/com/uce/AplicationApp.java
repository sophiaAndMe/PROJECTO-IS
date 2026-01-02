package com.uce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // Habilita la programación de tareas
public class AplicationApp {
    public static void main(String[] args) {
        SpringApplication.run(AplicationApp.class, args);
    }
}