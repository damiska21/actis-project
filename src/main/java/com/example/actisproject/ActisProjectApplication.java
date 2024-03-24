package com.example.actisproject;

import jakarta.annotation.PreDestroy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ActisProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActisProjectApplication.class, args);
        Database.CreateDatabase();
    }

    @PreDestroy
    public void onShutdown() throws Exception {
        System.out.println("Vypínání programu a mazání databáze!");
        Database.DropDatabase();
    }
}
