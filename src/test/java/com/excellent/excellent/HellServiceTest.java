package com.excellent.excellent;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HellServiceTest {
    @Test
    void simpleHelloService() {
        SimpleHelloService helloService = new SimpleHelloService(new MyHelloRepository());

        String test = helloService.hello("test");
        Assertions.assertThat(test).isEqualTo("Hello test");
    }

    private static class MyHelloRepository implements HelloRepository {
        @Override
        public Hello findHello(String name) {
            return null;
        }

        @Override
        public void increaseCount(String name) {

        }
    }
}
