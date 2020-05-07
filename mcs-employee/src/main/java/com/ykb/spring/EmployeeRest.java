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

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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

    private int                  counter;

    @HystrixCommand(fallbackMethod = "greetFallback",
                    commandProperties = {
                                          @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                                                           value = "500")
                    })
    @GetMapping("/greet")
    public String greet() {
        this.counter++;
        if ((this.counter % 3) == 0) {
            throw new IllegalArgumentException();
        }
        if ((this.counter % 5) == 0) {
            try {
                Thread.sleep(1_000);
            } catch (Exception eLoc) {
            }
        }
        return "Hello Employee " + this.port;
    }

    public String greetFallback() {
        return "Fallback " + this.port;
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
