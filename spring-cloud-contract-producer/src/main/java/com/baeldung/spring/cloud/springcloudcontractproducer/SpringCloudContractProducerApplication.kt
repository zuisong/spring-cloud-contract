package com.baeldung.spring.cloud.springcloudcontractproducer

import org.springframework.boot.*
import org.springframework.boot.autoconfigure.*

@SpringBootApplication
class SpringCloudContractProducerApplication {
}

fun main(args: Array<String>) {
    SpringApplication.run(SpringCloudContractProducerApplication::class.java, *args)
}
