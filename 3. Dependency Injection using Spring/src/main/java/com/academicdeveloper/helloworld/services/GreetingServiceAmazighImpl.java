package com.academicdeveloper.helloworld.services;

/*
PROJECT NAME : 3. Dependency Injection using Spring
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 2/26/2022 12:18 AM
*/

public class GreetingServiceAmazighImpl implements GreetingService{
    @Override
    public String getGreeting() {
        return "Azzul Fellawen!(Amazigh Version)";
    }
}
