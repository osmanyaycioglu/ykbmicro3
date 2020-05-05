package com.ykb.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/organization")
public class OrganizationRest {

    @Autowired
    private IEmployeeClient ec;


    @PostMapping("/create_employee")
    public String createEmployee() {
        return this.ec.greet();
    }


}
