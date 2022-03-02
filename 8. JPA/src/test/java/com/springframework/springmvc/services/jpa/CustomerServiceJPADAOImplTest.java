package com.springframework.springmvc.services.jpa;

import com.springframework.springmvc.config.JPAIntegrationConfig;
import com.springframework.springmvc.domain.Customer;
import com.springframework.springmvc.services.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;


/*
PROJECT NAME : 8. JPA
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 3/2/2022 2:43 PM
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JPAIntegrationConfig.class)
@ActiveProfiles("jpa")
public class CustomerServiceJPADAOImplTest {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Test
    public void listMethodTest() throws Exception {
        List<Customer> customers = (List<Customer>) customerService.listAll();
        assertEquals(customers.size(), 3);
    }
}