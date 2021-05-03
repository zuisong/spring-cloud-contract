package cn.mmooo

import com.baeldung.spring.cloud.springcloudcontractproducer.controller.*
import io.restassured.module.mockmvc.*
import org.springframework.test.web.servlet.setup.*
import spock.lang.*

class PrimeNumberBase extends Specification {
    Calculator calculator = Mock(Calculator) {
        isNumberPrime(_ as Integer) >> { Integer num -> num % 2 == 0 }
    }
    private EvenOddController evenOddController = new EvenOddController(calculator: calculator)

    def setup() {
        StandaloneMockMvcBuilder standaloneMockMvcBuilder =
                MockMvcBuilders
                        .standaloneSetup(evenOddController)
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder)
    }
}
