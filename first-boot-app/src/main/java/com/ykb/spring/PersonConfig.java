package com.ykb.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.xyz.MyClass;
import com.xyz.Myconfig;

@Configuration
@Import(Myconfig.class)
public class PersonConfig {

    @Bean
    @Qualifier("osman")
    public PersonManager createPersonManager() {
        return new PersonManager();
    }

    @Bean
    public PersonManager createPersonManager2() {
        return new PersonManager();
    }

    @Bean
    public MyClass myClass() {
        return new MyClass();
    }

}
