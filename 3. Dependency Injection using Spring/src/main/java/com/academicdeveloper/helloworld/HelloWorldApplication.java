package com.academicdeveloper.helloworld;

import com.academicdeveloper.helloworld.controllers.GreetingController;
import com.academicdeveloper.helloworld.di.InjectedByConstructorService;
import com.academicdeveloper.helloworld.di.SetterBasedService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
/*
* Spring 4 & Spring Boot
* */
@SpringBootApplication
public class HelloWorldApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(HelloWorldApplication.class, args);

//        InjectedByConstructorService constructorService =
//                (InjectedByConstructorService) context.getBean("injectedByConstructorService");
//        constructorService.getMessage();

//        SetterBasedService setterBasedService = (SetterBasedService) context.getBean("setterBasedService");
//        setterBasedService.getMessage();

        GreetingController greetingController = (GreetingController) context.getBean("greetingController");

        greetingController.sayHello();
    }

}
