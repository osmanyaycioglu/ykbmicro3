package com.ykb.spring;

import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.NoOpPing;

public class MyRibbonConfig {

    @Bean
    public IPing ping() {
        return new NoOpPing();
    }

    @Bean
    public IRule name() {
        return new AvailabilityFilteringRule();
    }
}
