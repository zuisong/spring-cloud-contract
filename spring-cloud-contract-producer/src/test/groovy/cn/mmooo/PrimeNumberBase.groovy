package cn.mmooo

import com.baeldung.spring.cloud.springcloudcontractproducer.controller.*
import io.restassured.module.mockmvc.*
import org.springframework.test.web.servlet.setup.*
import spock.lang.*

class PrimeNumberBase extends Specification {
    Calculator calculator = Mock(Calculator) {
        isNumberPrime(2) >> true
        isNumberPrime(1) >> false
    }
    private EvenOddController evenOddController = new EvenOddController(calculator: calculator)

    def setup() {
        StandaloneMockMvcBuilder standaloneMockMvcBuilder =
                MockMvcBuilders
                        .standaloneSetup(evenOddController)
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder)
    }
}
