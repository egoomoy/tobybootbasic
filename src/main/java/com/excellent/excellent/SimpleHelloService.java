package com.excellent.excellent;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SimpleHelloService implements HelloService {

    private final HelloRepository helloRepository;

    @Override
    public String hello(String name) {
        helloRepository.increaseCount(name);
        return "Hello " + name;
    }
}
