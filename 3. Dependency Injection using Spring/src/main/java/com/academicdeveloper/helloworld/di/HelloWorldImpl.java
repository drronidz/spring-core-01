package com.academicdeveloper.helloworld.di;

/*
PROJECT NAME : 2. Getting Started with Spring
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 2/25/2022 3:19 PM
*/

import org.springframework.stereotype.Component;

/* @Annotation Getting Registered as spring bean */
@Component
public class HelloWorldImpl implements HelloWorldService {

    public void sayHello() {
        System.out.println("Hello World !!");
    }
}
