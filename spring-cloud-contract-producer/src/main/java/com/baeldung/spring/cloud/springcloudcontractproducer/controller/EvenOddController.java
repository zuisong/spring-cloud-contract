package com.baeldung.spring.cloud.springcloudcontractproducer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EvenOddController {
    @Autowired
    private Calculator calculator;

    @GetMapping("/validate/prime-number")
    public String isNumberPrime(@RequestParam("number") Integer number) {
        return calculator.isNumberPrime(number) ? "Even" : "Odd";
    }
}

