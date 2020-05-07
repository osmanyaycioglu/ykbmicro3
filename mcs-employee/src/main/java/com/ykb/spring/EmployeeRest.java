package com.ykb.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.bus.SpringCloudBusClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ykb.spring.cloud.bus.MyRemoteEvent;

@RestController
@RequestMapping("/employee")
@RefreshScope
public class EmployeeRest {

    @Value("${server.port}")
    // @Value("#{beanname.method()}")
    private int                  port;

    @Value("${my.propery}")
    private String               myConf;

    @Autowired
    private ApplicationContext   appc;

    @Autowired
    private SpringCloudBusClient scbc;


    @GetMapping("/greet")
    public String greet() {
        return "Hello Employee " + this.port;
    }

    @GetMapping("test")
    public String abc() {
        return this.myConf;
    }

    @GetMapping("/event")
    public String event() {
        MyRemoteEvent eventLoc = new MyRemoteEvent(this,
                                                   this.appc.getId(),
                                                   "Remote event test");
        this.scbc.springCloudBusOutput()
                 .send(MessageBuilder.withPayload(eventLoc)
                                     .build());

        return "OK";
    }

}
