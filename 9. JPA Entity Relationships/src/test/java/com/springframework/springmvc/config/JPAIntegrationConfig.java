package com.springframework.springmvc.config;

/*
PROJECT NAME : 8. JPA
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 3/2/2022 1:44 PM
*/

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.springframework.springmvc")
public class JPAIntegrationConfig {
}
