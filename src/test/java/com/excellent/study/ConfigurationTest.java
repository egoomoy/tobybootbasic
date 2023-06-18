package com.excellent.study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ConfigurationTest {
    @Test
    void configuration() {
//        Common common = new Common();
//        Assertions.assertThat(common).isSameAs(common);

//        MyConfig myConfig = new MyConfig();
//
//        Bean1 bean1 = myConfig.bean1();
//        Bean2 bean2 = myConfig.bean2();
//        Assertions.assertThat(bean1.common).isSameAs(bean2.common);

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(MyConfig.class);
        ac.refresh( );
        Bean1 bean1 = ac.getBean(Bean1.class);
        Bean2 bean2 = ac.getBean(Bean2.class);
        Assertions.assertThat(bean1.common).isSameAs(bean2.common);


        // 토비의 불만은 일반적인 자바에서 기대되는 결과 값과 스프링에서 반환되는 결과 값이 다름
        // 위 예제에서 기대되는 결과는 다른 common 객체인데, 실제로는 테스트를 통과함
        // 이게 바로 proxy객체 => jpa에서도 유사한 개념이 있잖아? 프록시를 프록시로 이해하면 될 듯
    }

    @Configuration
    static class MyConfig {
        @Bean
        Common common() {
            return new Common();
        }
        @Bean
        Bean1 bean1() {
            return new Bean1(common());
        }
        @Bean
        Bean2 bean2() {
            return new Bean2(common());
        }
    }

    static class Bean1 {
        public Bean1(Common common) {
            this.common = common;
        }

        private final Common common;

    }

    static class Bean2 {
        private final Common common;

        public Bean2(Common common) {
            this.common = common;
        }
    }

    static class Common {
    }

    // Bean1 <-- Common
    // Bean2 <-- Common
}
