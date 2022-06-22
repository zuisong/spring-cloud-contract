package com.baeldung.spring.cloud.springcloudcontractconsumer.controller

import com.baeldung.spring.cloud.springcloudcontractconsumer.*
import org.springframework.beans.factory.annotation.*
import org.springframework.context.support.*
import org.springframework.web.bind.annotation.*

@RestController
class BasicMathController {

    @Autowired
    private lateinit var producerFeign: ProducerFeign


    @Autowired
    private lateinit var applicationContext: AbstractApplicationContext

    @GetMapping("/calculate")
    fun checkOddAndEven(@RequestParam("number") number: Int): String {
        val responseEntity = producerFeign.isNumberPrime(number)
        return responseEntity
    }

    @GetMapping("/echo")
    fun echo(@RequestParam("message") message: String): String {
        val responseEntity = producerFeign.echo(message)
        return responseEntity
    }
}
