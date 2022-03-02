package com.springframework.springmvc.services.jpa;

import com.diogonunes.jcolor.Attribute;
import com.springframework.springmvc.config.JPAIntegrationConfig;
import com.springframework.springmvc.domain.Customer;
import com.springframework.springmvc.domain.User;
import com.springframework.springmvc.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.BOLD;
import static org.junit.Assert.*;


/*
PROJECT NAME : 9. JPA Entity Relationships
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 3/2/2022 3:35 PM
*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JPAIntegrationConfig.class)
@ActiveProfiles("jpa")
public class UserServiceJPADAOImplTest {

    private UserService userService;

    Attribute backgroundColorOne = Attribute.BACK_COLOR(132, 147, 36);
    Attribute backgroundColorTwo = Attribute.BACK_COLOR(1, 41, 95);
    Attribute backgroundLight = Attribute.BACK_COLOR(255, 255, 255);
    Attribute backgroundDark = Attribute.BACK_COLOR(0, 0, 0);

    Attribute textColorLight = Attribute.TEXT_COLOR(255, 255, 255);
    Attribute textColorDark = Attribute.TEXT_COLOR(0, 0, 0);

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void saveOfUserTest() throws Exception {
        User user = new User();
        user.setUsername("drronidz");
        user.setPassword("12041994setif");

        User savedUser = userService.saveOrUpdate(user);

        assertNotEquals(savedUser.getId(), null);
        assertNotEquals(java.util.Optional.ofNullable(savedUser.getId()), 0);

        System.out.println(colorize("Encrypted Password", BOLD(), textColorDark, backgroundLight));
        System.out.println(colorize(savedUser.getEncryptedPassword(), BOLD(), textColorDark, backgroundColorOne));
    }

    @Test
    public void saveOfUserWithCustomer() throws Exception {
        User user = new User();

        user.setUsername("drronidz");
        user.setPassword("12041994setif");

        Customer customer = new Customer();
        customer.setFirstName("Chevy");
        customer.setLastName("Chase");

        user.setCustomer(customer);

        User savedUser = userService.saveOrUpdate(user);

        assert savedUser.getId() != null;
        assert savedUser.getVersion() != null;
        assert savedUser.getCustomer() != null;
        assert savedUser.getCustomer().getId() != null;
    }
}