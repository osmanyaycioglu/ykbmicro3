package com.ykb.spring;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class DepartmentQueueListener {

    @Value("${server.port}")
    private int port;

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "department_q",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "de_department_exc",
                                                                  type = ExchangeTypes.DIRECT,
                                                                  durable = "true"),
                                             key = "my.department.key"))
    @SendTo("de_d_result_exc/my.result.key")
    public String abc(final Department dep) {
        System.out.println(this.port + " Input abc : " + dep);
        return this.port + " Input abc : " + dep;
    }


    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "department_q_2",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "de_department_exc",
                                                                  type = ExchangeTypes.DIRECT,
                                                                  durable = "true"),
                                             key = "my.dep2.key"))
    @SendTo("de_d_result_exc/my.result.key")
    public String xyz(final Department dep) {
        System.out.println(this.port + " Input xyz : " + dep);
        return this.port + " Input xyz : " + dep;
    }


    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "department_q_3",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "te_dep_exc",
                                                                  type = ExchangeTypes.TOPIC,
                                                                  durable = "true"),
                                             key = "my.*.tt"))
    public void qwe(final Department dep) {
        System.out.println(this.port + " Input qwe : " + dep);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "department_q_4",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "te_dep_exc",
                                                                  type = ExchangeTypes.TOPIC,
                                                                  durable = "true"),
                                             key = "my.#"))
    public void asd(final Department dep) {
        System.out.println(this.port + " Input asd : " + dep);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "department_q_5",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "fan_dep_exc",
                                                                  type = ExchangeTypes.FANOUT,
                                                                  durable = "true"),
                                             key = ""))
    public void bnm1(final Department dep) {
        System.out.println(this.port + " Input bnm1 : " + dep);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "department_q_6",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "fan_dep_exc",
                                                                  type = ExchangeTypes.FANOUT,
                                                                  durable = "true"),
                                             key = ""))
    public void bnm2(final Department dep) {
        System.out.println(this.port + " Input bnm2 : " + dep);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "department_q_7",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "fan_dep_exc",
                                                                  type = ExchangeTypes.FANOUT,
                                                                  durable = "true"),
                                             key = ""))
    public void bnm3(final Department dep) {
        System.out.println(this.port + " Input bnm3 : " + dep);
    }

}
