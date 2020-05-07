package com.ykb.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableEurekaClient
@RemoteApplicationEventScan
@EnableCircuitBreaker
@EnableResourceServer
public class McsEmployeeApplication {

    public static void main(final String[] args) {
        SpringApplication.run(McsEmployeeApplication.class,
                              args);
    }

}
