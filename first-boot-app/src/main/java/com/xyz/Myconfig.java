package com.xyz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Myconfig {

    @Bean
    public MyClass myClass1() {
        return new MyClass();
    }

}
