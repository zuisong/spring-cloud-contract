package com.baeldung;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.baeldung.spring.cloud.springcloudcontractconsumer.SpringCloudContractConsumerApplication;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SpringCloudContractConsumerApplication.class)
public class SpringContextTest {

    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }
}
