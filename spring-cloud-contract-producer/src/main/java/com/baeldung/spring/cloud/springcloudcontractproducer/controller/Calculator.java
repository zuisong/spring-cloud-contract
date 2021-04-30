package com.baeldung.spring.cloud.springcloudcontractproducer.controller;

import org.springframework.stereotype.Component;

@Component
public
class Calculator {
    public boolean isNumberPrime(Integer number) {
        return number % 2 == 0;
    }
}
