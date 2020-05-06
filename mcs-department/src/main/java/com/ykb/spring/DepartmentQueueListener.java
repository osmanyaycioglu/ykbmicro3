package com.ykb.spring;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DepartmentQueueListener {


    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "department_q",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "de_department_exc",
                                                                  type = ExchangeTypes.DIRECT,
                                                                  durable = "true"),
                                             key = "my.department.key"))
    public void abc(final String str) {
        System.out.println("Input : " + str);
    }

}
