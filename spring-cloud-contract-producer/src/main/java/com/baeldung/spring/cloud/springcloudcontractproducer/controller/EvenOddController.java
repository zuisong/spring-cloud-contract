package com.baeldung.spring.cloud.springcloudcontractproducer.controller;


import org.springframework.web.bind.annotation.*;

@RestController
public class EvenOddController {

    @GetMapping("/validate/prime-number")
    public String isNumberPrime(@RequestParam("number") Integer number) {
        return number % 2 == 0 ? "Even" : "Odd";
    }
}
