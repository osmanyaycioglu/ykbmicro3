package com.ykb.spring;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/organization")
public class OrganizationRest {

    @Autowired
    private IEmployeeClient ec;

    @Autowired
    private RabbitTemplate  rt;

    @PostMapping("/create_employee")
    public String createEmployee() {
        Department dLoc = new Department();
        dLoc.setName("IT");
        dLoc.setEmployeeCount(100);
        dLoc.setCreateYear(1980);
        dLoc.setCreateMonth(1);

        this.rt.convertAndSend("de_department_exc",
                               "my.dep2.key",
                               dLoc);

        return this.ec.greet();
    }


}
