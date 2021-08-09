package com.example.webui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class WebuiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebuiApplication.class, args);
    }

}
