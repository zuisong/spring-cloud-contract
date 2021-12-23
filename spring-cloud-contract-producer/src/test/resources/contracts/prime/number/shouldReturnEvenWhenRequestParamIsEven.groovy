package contracts.prime.number

import org.springframework.cloud.contract.spec.*
import org.springframework.cloud.contract.spec.internal.MediaTypes

Contract.make {
    description "should return even when number input is even"
    request {
        method GET()
        headers {
            contentType MediaTypes.APPLICATION_JSON
        }
        url("/validate/prime-number") {

            queryParameters {
                [
                        "number"    : "2",
                ].forEach { k, v -> parameter(k, v) }
            }
        }
    }
    response {
        body("Even")
        status 200
    }
}
