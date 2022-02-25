package com.academicdeveloper.helloworld.services;

/*
PROJECT NAME : 3. Dependency Injection using Spring
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 2/26/2022 12:54 AM
*/

public class GreetingServiceGermanImpl implements GreetingService{
    @Override
    public String getGreeting() {
        return "Hello Welt!";
    }
}
