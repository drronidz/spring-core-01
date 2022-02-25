package com.academicdeveloper.helloworld.controllers;

/*
PROJECT NAME : 3. Dependency Injection using Spring
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 2/25/2022 11:17 PM
*/

import com.academicdeveloper.helloworld.di.HelloWorldService;
import com.academicdeveloper.helloworld.services.GreetingService;
import com.academicdeveloper.helloworld.services.GreetingServiceArabicImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

    private GreetingService greetingService;

    private GreetingService greetingServiceGerman;

    private GreetingService greetingServiceArabic;

    @Autowired
    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @Autowired
    @Qualifier("greetingServiceGerman")
    public void setGreetingServiceGerman(GreetingService greetingServiceGerman) {
        this.greetingServiceGerman = greetingServiceGerman;
    }

    @Autowired
    @Qualifier("arabic")
    public void setGreetingServiceArabic (GreetingService greetingServiceArabic) {
        this.greetingServiceArabic = greetingServiceArabic;
    }

    public String sayHello() {
        String greeting = greetingService.getGreeting();
        System.out.println("############## " + greeting + " ##############");
        System.out.println(greetingServiceArabic.getGreeting());
        System.out.println(greetingServiceGerman.getGreeting());
        return greeting;
    }
}
