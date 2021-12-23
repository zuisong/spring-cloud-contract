package com.baeldung.spring.cloud.springcloudcontractconsumer.controller

import io.restassured.http.*
import io.restassured.module.mockmvc.*
import org.springframework.beans.factory.annotation.*
import org.springframework.boot.test.autoconfigure.json.*
import org.springframework.boot.test.autoconfigure.web.servlet.*
import org.springframework.boot.test.context.*
import org.springframework.cloud.contract.stubrunner.spring.*
import org.springframework.test.web.servlet.*
import spock.lang.*

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids = "com.baeldung.spring.cloud:spring-cloud-contract-producer:+:stubs:8090")
class BasicMathControllerIntegrationSpec extends Specification {

    @Autowired
    private MockMvc mockMvc

    def setup() {
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
