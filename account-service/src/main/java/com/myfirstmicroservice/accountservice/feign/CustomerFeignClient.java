package com.myfirstmicroservice.accountservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "CUSTOMER-SERVICE")
public interface CustomerFeignClient {

    @GetMapping("/api/customers/hello")
    String sayHello();
}
