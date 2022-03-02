package com.springframework.springmvc.services.jpa;

import com.diogonunes.jcolor.Attribute;
import com.springframework.springmvc.config.JPAIntegrationConfig;
import com.springframework.springmvc.domain.*;
import com.springframework.springmvc.services.ProductService;
import com.springframework.springmvc.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

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

    private ProductService productService;

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

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
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

    @Test
    public void addCartToUserTest() throws Exception {
        User user = new User();

        user.setUsername("drronidz");
        user.setPassword("12041994setif");

        user.setCart(new Cart());

        User savedUser = userService.saveOrUpdate(user);

        assert savedUser.getId() != null;
        assert savedUser.getVersion() != null;
        assert savedUser.getCart() != null;
        assert savedUser.getCart().getId() != null;
    }

    @Test
    public void addCartWithCartDetailsToUserTest() throws Exception {
        User user = new User();

        user.setUsername("drronidz");
        user.setPassword("12041994setif");

        user.setCart(new Cart());

        List<Product> storedProducts = (List<Product>) productService.listAll();

        CartDetail cartItemOne = new CartDetail();
        cartItemOne.setProduct(storedProducts.get(0));
        user.getCart().addCartDetail(cartItemOne);

        CartDetail cartItemTwo = new CartDetail();
        cartItemTwo.setProduct(storedProducts.get(1));
        user.getCart().addCartDetail(cartItemTwo);

        User savedUser = userService.saveOrUpdate(user);

        assert savedUser.getId() != null;
        assert savedUser.getVersion() != null;
        assert savedUser.getCart() != null;
        assert savedUser.getCart().getId() != null;
        assert savedUser.getCart().getCartDetails().size() == 2;
    }

    @Test
    public void addAndRemoveCartToUserWithCartDetails() throws Exception {
        User user = new User();

        user.setUsername("drronidz");
        user.setPassword("12041994setif");

        user.setCart(new Cart());

        List<Product> storedProducts = (List<Product>) productService.listAll();

        CartDetail cartItemOne = new CartDetail();
        cartItemOne.setProduct(storedProducts.get(0));
        user.getCart().addCartDetail(cartItemOne);

        CartDetail cartItemTwo = new CartDetail();
        cartItemTwo.setProduct(storedProducts.get(1));
        user.getCart().addCartDetail(cartItemTwo);

        User savedUser = userService.saveOrUpdate(user);

        assert savedUser.getCart().getCartDetails().size() == 2;

        savedUser.getCart().removeCartDetail(savedUser.getCart().getCartDetails().get(0));

        userService.saveOrUpdate(savedUser);

        assert savedUser.getCart().getCartDetails().size() == 1;
    }
}