package com.xyz;

import org.springframework.stereotype.Component;

@Component
public class MyClass {

    private String name;


    public String getName() {
        return this.name;
    }


    public void setName(final String nameParam) {
        this.name = nameParam;
    }

}
