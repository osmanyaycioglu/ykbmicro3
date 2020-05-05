package com.ykb.spring;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "employee")
@RequestMapping("/employee")
public interface IEmployeeClient {

    @GetMapping("/greet")
    public String greet();
}
