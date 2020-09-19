package com.kstu.sport.controllers;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class TestController {

    @GetMapping("/exception")
    public void getAccount() {
        throw new IllegalArgumentException("Test exception");
    }
}
