package com.ykb.spring;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyHealth implements HealthIndicator {

    @Override
    public Health health() {
        return Health.up()
                     .withDetail("success",
                                 "iyiyim")
                     .build();

        //        return Health.down()
        //                     .withDetail("error",
        //                                 "şu anda doluyum")
        //                     .build();
    }

}
