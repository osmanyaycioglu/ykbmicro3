package com.ykb.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication(scanBasePackages = {"com.ykb.spring","com.ykb.handler"})
@SpringBootApplication
public class FirstBootAppApplication {

    public static void main(final String[] args) {
        SpringApplication.run(FirstBootAppApplication.class,
                              args);
    }

}
