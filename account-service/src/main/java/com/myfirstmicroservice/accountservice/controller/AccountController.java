package com.myfirstmicroservice.accountservice.controller;

import com.myfirstmicroservice.accountservice.feign.CustomerFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final CustomerFeignClient customerFeignClient;

    @GetMapping("/send")
    @ResponseStatus(HttpStatus.OK)
    public String helloResponse() {
        return customerFeignClient.sayHello();
    }
}
