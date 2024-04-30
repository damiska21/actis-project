package com.example.actisproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.util.Date;

@RestController
public class Controller {
    @GetMapping("/api/test/{resourceId}")
    public String getString(@PathVariable String resourceId) {
        return "string :3  tvý číslo: " + resourceId;
    }
    @GetMapping("/error")
    public String error() {
        return String.format("Něco jsem sprasil D:");
    }
    @GetMapping("/database")
    public String db(){
        return String.format(Database.get());
    }
    @GetMapping("/database/add")
    public String add(@RequestParam(value = "name", defaultValue = ";")String name, @RequestParam(value = "surname", defaultValue = ";")String surname, @RequestParam(value = "age", defaultValue = "-1")Integer age, @RequestParam(value = "date", defaultValue = "2000-01-01") java.sql.Date birthday, @RequestParam(value = "gender", defaultValue = "true")Boolean gender){

        return String.format(Database.addPerson(name, surname, age, birthday, gender));
    }
    @GetMapping("")
    public String uvod(){
        return String.format("Zdravím na webu! Vše důležité je v dokumentaci");
    }
}
