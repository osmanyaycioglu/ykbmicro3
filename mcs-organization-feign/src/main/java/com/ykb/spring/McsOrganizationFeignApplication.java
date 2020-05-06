package com.ykb.spring;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableRabbit
public class McsOrganizationFeignApplication {

    public static void main(final String[] args) {
        SpringApplication.run(McsOrganizationFeignApplication.class,
                              args);
    }

}
