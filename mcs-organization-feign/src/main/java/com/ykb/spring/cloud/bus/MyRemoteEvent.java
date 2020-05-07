package com.ykb.spring.cloud.bus;

import org.springframework.cloud.bus.event.RemoteApplicationEvent;

public class MyRemoteEvent extends RemoteApplicationEvent {

    private static final long serialVersionUID = -3161524946797085351L;

    private String            message;

    public MyRemoteEvent() {
    }

    public MyRemoteEvent(final Object source,
                         final String uid,
                         final String messParam) {
        super(source,
              uid);
        this.message = messParam;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(final String messageParam) {
        this.message = messageParam;
    }


}
