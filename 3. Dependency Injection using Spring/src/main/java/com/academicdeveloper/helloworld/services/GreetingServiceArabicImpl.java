package com.academicdeveloper.helloworld.services;

/*
PROJECT NAME : 3. Dependency Injection using Spring
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 2/26/2022 12:07 AM
*/

public class GreetingServiceArabicImpl implements GreetingService{
    @Override
    public String getGreeting() {
        return "صباح الخير ياعالم!" + "(Arabic Version)";
    }
}
