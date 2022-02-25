package com.academicdeveloper.helloworld.services;

/*
PROJECT NAME : 3. Dependency Injection using Spring
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 2/26/2022 12:09 AM
*/

public class GreetingFactory {

    public GreetingService createGreetingService(String language) {
        GreetingService greetingService = null;

        switch (language) {
            case "en":
                greetingService = new GreetingServiceEnglishImpl();
                break;
            case "es":
                greetingService = new GreetingServiceSpanishImpl();
                break;
            case "fr":
                greetingService = new GreetingServiceFrenchImpl();
                break;
            case "ar":
                greetingService = new GreetingServiceArabicImpl();
                break;
            case "az":
                greetingService = new GreetingServiceAmazighImpl();
            default:
                new GreetingServiceEnglishImpl();
        }

        return greetingService;
    }
}
