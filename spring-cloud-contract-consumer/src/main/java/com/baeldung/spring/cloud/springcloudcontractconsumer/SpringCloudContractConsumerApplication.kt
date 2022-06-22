package com.baeldung.spring.cloud.springcloudcontractconsumer

import org.springframework.boot.*
import org.springframework.boot.autoconfigure.*
import org.springframework.cloud.openfeign.*
import org.springframework.context.annotation.*
import org.springframework.web.client.*

@SpringBootApplication
@EnableFeignClients(basePackageClasses = [ProducerFeign::class])
class SpringCloudContractConsumerApplication

fun main(args: Array<String>) {
    SpringApplication.run(SpringCloudContractConsumerApplication::class.java, *args)
}
