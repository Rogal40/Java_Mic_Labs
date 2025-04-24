package org.example.teamservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "org.example.teamservice.client")
public class TeamServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeamServiceApplication.class, args);
    }

}
