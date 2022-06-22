package com.baeldung.spring.cloud.springcloudcontractconsumer.controller

import com.baeldung.spring.cloud.springcloudcontractconsumer.SpringCloudContractConsumerApplication
import io.restassured.http.ContentType
import io.restassured.module.mockmvc.RestAssuredMockMvc
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MockMvcBuilder
import spock.lang.Specification

@SpringBootTest(classes = SpringCloudContractConsumerApplication.class)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@AutoConfigureStubRunner
class BasicMathControllerIntegrationSpec extends Specification {

    @Autowired
    private MockMvcBuilder mockMvcBuilder

    @Autowired
    private MockMvc mockMvc

    def setup() {
        println "Mock MVC"
        Objects.requireNonNull(mockMvc)
        RestAssuredMockMvc.mockMvc(mockMvc)
    }

    def given_WhenPassEvenNumberInQueryParam_ThenReturnEven() throws Exception {

        when:
        def resp = RestAssuredMockMvc.given()
                .contentType(ContentType.JSON)
                .get("/calculate?number=2")
        then:
        resp.statusCode() == 200
        resp.body().asString() == 'Even'


    }

    def given_WhenPassOddNumberInQueryParam_ThenReturnOdd() throws Exception {


        when:
        def resp = RestAssuredMockMvc.given()
                .contentType(ContentType.JSON)
                .get("/calculate?number=1")
        then:
        resp.statusCode() == 200
        resp.body().asString() == 'Odd'

    }
}
