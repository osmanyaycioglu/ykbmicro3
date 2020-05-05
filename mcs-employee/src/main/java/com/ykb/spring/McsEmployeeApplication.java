package com.ykb.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class McsEmployeeApplication {

    public static void main(final String[] args) {
        SpringApplication.run(McsEmployeeApplication.class,
                              args);
    }

}
