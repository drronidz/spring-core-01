package com.academicdeveloper.helloworld;

/*
PROJECT NAME : 3. Dependency Injection using Spring
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 2/26/2022 12:27 PM
*/

import com.academicdeveloper.helloworld.services.GreetingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations = {
                "classpath:/spring/greeting-config.xml",
                "classpath:/spring/greeting-english-config.xml"
        }
)
public class EnglishIntegrationTest {

    @Autowired
    GreetingService greetingService;

    @Test
    public void testHelloWorld() {
        String greeting = greetingService.getGreeting();
        assertEquals("Hello World! (English Version)", greeting);
    }
}
