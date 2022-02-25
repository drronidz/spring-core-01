package com.academicdeveloper.helloworld.config;

/*
PROJECT NAME : 3. Dependency Injection using Spring
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 2/25/2022 11:59 PM
*/

import com.academicdeveloper.helloworld.services.GreetingFactory;
import com.academicdeveloper.helloworld.services.GreetingService;
import com.academicdeveloper.helloworld.services.GreetingServiceEnglishImpl;
import com.academicdeveloper.helloworld.services.GreetingServiceSpanishImpl;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingConfig {

    @Bean
    public GreetingFactory greetingFactory(){
        return new GreetingFactory();
    }

    @Bean
    @Profile("english")
    public GreetingService greetingServiceEnglish(GreetingFactory factory) {
        return factory.createGreetingService("en");
    }

    @Bean
    @Profile("spanish")
    public GreetingService greetingServiceSpanish(GreetingFactory factory) {
        return factory.createGreetingService("es");
    }

    @Bean
    @Profile("french")
    public GreetingService greetingServiceFrench(GreetingFactory factory) {
        return factory.createGreetingService("fr");
    }

    @Bean
    @Profile("arabic")
    public GreetingService greetingServiceArabic(GreetingFactory factory) {
        return factory.createGreetingService("ar");
    }

    @Bean
    @Profile("amazigh")
    public GreetingService greetingServiceAmazigh(GreetingFactory factory) {
        return factory.createGreetingService("az");
    }
}
