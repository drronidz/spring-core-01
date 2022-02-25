package com.academicdeveloper.helloworld.springboot;

import com.academicdeveloper.helloworld.controllers.GreetingController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/*
* Spring 4 & Spring Boot
* */
@SpringBootApplication
@ComponentScan("com.academicdeveloper.helloworld")
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
