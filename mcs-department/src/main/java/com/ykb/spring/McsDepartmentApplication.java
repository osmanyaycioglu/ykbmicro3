package com.ykb.spring;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;

@SpringBootApplication
@EnableRabbit
@RemoteApplicationEventScan
public class McsDepartmentApplication {

    public static void main(final String[] args) {
        SpringApplication.run(McsDepartmentApplication.class,
                              args);
    }

}
