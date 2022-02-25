package com.academicdeveloper.helloworld.di;

/*
PROJECT NAME : 3. Dependency Injection using Spring
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 2/25/2022 10:59 PM
*/

import org.springframework.stereotype.Component;

@Component
public interface HelloWorldService {
    void sayHello();
}
