package com.academicdeveloper.helloworld.services;

/*
PROJECT NAME : 3. Dependency Injection using Spring
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 2/25/2022 11:22 PM
*/

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"default","english"})
public class GreetingServiceEnglishImpl implements GreetingService {

    @Override
    public String getGreeting() {
        return "Hello World! (English Version)";
    }
}
