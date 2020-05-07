package com.ykb.spring;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/organization")
@RefreshScope
public class OrganizationRest {

    @Autowired
    private IEmployeeClient ec;

    @Autowired
    private RabbitTemplate  rt;

    @Value("${my.propery}")
    private String          myConf;

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

    @GetMapping("test")
    public String abc() {
        return this.myConf;
    }


}
