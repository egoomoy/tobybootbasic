package com.excellent.excellent;

import com.excellent.config.MySpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;


//@SpringBootApplication
@MySpringBootApplication
public class ExcellentApplication {

    @Bean
    ApplicationRunner applicationRunner(Environment env) {
        return args -> {
            String name = env.getProperty("my.name");
            System.out.println(name);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ExcellentApplication.class, args);
    }
}
