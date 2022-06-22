package com.baeldung.spring.cloud.springcloudcontractconsumer

import org.springframework.cloud.openfeign.*
import org.springframework.web.bind.annotation.*

@FeignClient(name = "producer")
interface ProducerFeign {


    @GetMapping("/validate/prime-number")
    fun isNumberPrime(@RequestParam("number") number: Int?): String

    @GetMapping("/echo")
    fun echo(@RequestParam("message") message: String?): String

}
