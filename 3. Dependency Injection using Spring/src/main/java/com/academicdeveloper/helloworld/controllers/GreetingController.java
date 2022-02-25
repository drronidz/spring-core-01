package com.academicdeveloper.helloworld.controllers;

/*
PROJECT NAME : 3. Dependency Injection using Spring
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 2/25/2022 11:17 PM
*/

import com.academicdeveloper.helloworld.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

    private GreetingService greetingService;

    @Autowired
    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        String greeting = greetingService.getGreeting();
        System.out.println("############## " + greeting + " ##############");
        return greeting;
    }
}
