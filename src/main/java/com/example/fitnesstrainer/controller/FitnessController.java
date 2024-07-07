package com.example.fitnesstrainer.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FitnessController {


    @GetMapping("/")
    @CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
    public String toString() {
        return "hello, world!";
    }
}
