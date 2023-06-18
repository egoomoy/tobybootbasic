package com.excellent.excellent;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Primary
public class HelloDecorator implements HelloService{

    private final HelloService helloService;

    @Override
    public String hello(String name) {
        return "***" + helloService.hello(name);
    }
}
