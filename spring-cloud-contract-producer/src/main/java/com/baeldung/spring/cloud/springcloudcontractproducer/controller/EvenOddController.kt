package com.baeldung.spring.cloud.springcloudcontractproducer.controller

import org.springframework.beans.factory.annotation.*
import org.springframework.web.bind.annotation.*

@RestController
class EvenOddController {
    @Autowired
    private var calculator: Calculator? = null
    @GetMapping("/validate/prime-number")
    fun isNumberPrime(@RequestParam("number") number: Int): String {
        return if (calculator!!.isNumberPrime(number)) "Even" else "Odd"
    }

    @GetMapping("/echo")
    fun isNumberPrime(@RequestParam("message") message: String): String {
        return message
    }
}
