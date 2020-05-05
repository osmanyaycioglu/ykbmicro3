package com.ykb.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class McsOrganizationApplication {

    public static void main(final String[] args) {
        SpringApplication.run(McsOrganizationApplication.class,
                              args);
    }

}
