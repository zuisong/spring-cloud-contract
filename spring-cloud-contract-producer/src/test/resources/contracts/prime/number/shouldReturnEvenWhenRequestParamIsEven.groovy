package contracts.prime.number

import org.springframework.cloud.contract.spec.*

Contract.make {
    priority(10)
    description "should return even when number input is even"
    request {
        method GET()
        url("/validate/prime-number") {
            queryParameters {
                ["number": "2",]
                        .forEach { k, v -> parameter(k, v)
                        }
            }
        }
    }
    response {
        body("Even")
        status 200
    }
}
