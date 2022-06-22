package contracts.prime.number

import org.springframework.cloud.contract.spec.*

Contract.make {
    priority(1)
    description "should return odd when number input is odd"
    request {
        method GET()
        url("/validate/prime-number") {
            queryParameters {
                [
                        "number"    : "1",
                ]
                        .forEach { k, v ->
                            parameter(k, v)
                        }
            }
        }
    }
    response {
        body("Odd")
        status 200
    }
}
