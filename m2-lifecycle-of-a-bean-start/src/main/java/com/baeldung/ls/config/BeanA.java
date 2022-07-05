package com.baeldung.ls.config;

import javax.annotation.PostConstruct;

public class BeanA {
    @PostConstruct
    public void post(){
        System.out.println("Post Constructor");
    };
}
