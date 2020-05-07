package com.ykb.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// @SpringBootApplication(scanBasePackages = {"com.ykb.spring","com.ykb.handler"})
@SpringBootApplication
@EnableSwagger2
public class FirstBootAppApplication {

    @Bean
    public Docket createDocket() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                                                      .apis(RequestHandlerSelectors.any())
                                                      .paths(PathSelectors.any())
                                                      .build();
    }

    public static void main(final String[] args) {
        SpringApplication.run(FirstBootAppApplication.class,
                              args);
    }

}
