package cn.mmooo

import com.baeldung.spring.cloud.springcloudcontractproducer.controller.*
import io.restassured.module.mockmvc.*
import org.springframework.test.web.servlet.setup.*
import spock.lang.*

class PrimeNumberBase extends Specification {
    private EvenOddController evenOddController = new EvenOddController()

    def setup() {
        StandaloneMockMvcBuilder standaloneMockMvcBuilder =
                MockMvcBuilders
                        .standaloneSetup(evenOddController)
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder)
    }
}
