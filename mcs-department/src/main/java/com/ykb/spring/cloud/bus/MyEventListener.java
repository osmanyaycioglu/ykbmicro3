package com.ykb.spring.cloud.bus;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventListener {

    @EventListener(MyRemoteEvent.class)
    public void handle(final MyRemoteEvent eventParam) {
        System.out.println("Event : " + eventParam.getMessage());
    }

}
