package com.ykb.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RibbonClient(name = "EMPLOYEE", configuration = MyRibbonConfig.class)
public class McsOrganizationApplication {

    public static void main(final String[] args) {
        SpringApplication.run(McsOrganizationApplication.class,
                              args);
    }

}
