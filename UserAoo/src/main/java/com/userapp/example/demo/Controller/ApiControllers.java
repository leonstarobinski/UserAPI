package com.userapp.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiControllers {
    @GetMapping(value = "/")
    public String getPage(){
        return "Welcome. Please view the ReadMe file for explanation of how to use this API";
    }
}


