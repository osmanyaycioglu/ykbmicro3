package com.ykb.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/organization")
public class OrganizationRest {

    @Autowired
    private RestTemplate restTemp;

    @PostMapping("/create_employee")
    public String createEmployee() {
        String forObjectLoc = this.restTemp.getForObject("http://EMPLOYEE/employee/greet",
                                                         String.class);
        return forObjectLoc;
    }

}
