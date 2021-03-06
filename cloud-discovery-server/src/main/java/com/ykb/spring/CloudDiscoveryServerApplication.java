package com.ykb.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CloudDiscoveryServerApplication {

    public static void main(final String[] args) {
        SpringApplication.run(CloudDiscoveryServerApplication.class,
                              args);
    }

}
