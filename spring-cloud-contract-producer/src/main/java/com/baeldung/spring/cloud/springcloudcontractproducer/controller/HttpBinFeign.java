package com.baeldung.spring.cloud.springcloudcontractproducer.controller;


import feign.Headers;
import feign.codec.Encoder;
import feign.form.ContentType;
import feign.form.FormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@FeignClient(url = "https://httpbin.org", name = "httpbin"

//        configuration = CoreFeignConfiguration.class
)
public interface HttpBinFeign {

    @PostMapping(value = "/post", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}
    )
    public String postWithForm(@RequestBody Map<String, Object> param);


    default String postParam(String param) {
        final HashMap<String, Object> map = new HashMap<>();
        map.put("param", param);
        return postWithForm(map);
    }
}
