package com.baeldung.spring.cloud.springcloudcontractproducer.controller

import org.springframework.stereotype.*

@Component
class Calculator {
    fun isNumberPrime(number: Int): Boolean {
        return number % 2 == 0
    }
}
