package com.ykb.spring;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DepartmentResultListener {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "d_result_q",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "de_d_result_exc",
                                                                  type = ExchangeTypes.DIRECT,
                                                                  durable = "true"),
                                             key = "my.result.key"))
    public void resultHandler(final String result) {
        System.out.println(result);
    }

}
