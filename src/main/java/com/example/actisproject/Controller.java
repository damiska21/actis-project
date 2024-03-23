package com.example.actisproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;

@RestController
public class Controller {
    @GetMapping("/api/test/{resourceId}")
    public String getString(@PathVariable String resourceId) {
        return "string :3  tvý číslo: " + resourceId;
    }
    @GetMapping("/error")
    public String errorik() {
        return String.format("Něco jsem sprasil D:");
    }
    @GetMapping("/database")
    public String db(){
        return String.format(Database.databaseGet());
    }
}
