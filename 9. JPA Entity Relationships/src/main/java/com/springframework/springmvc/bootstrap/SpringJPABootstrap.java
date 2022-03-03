package com.springframework.springmvc.bootstrap;

/*
PROJECT NAME : 8. JPA
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 3/1/2022 11:19 PM
*/

import com.springframework.springmvc.domain.*;
import com.springframework.springmvc.services.CustomerService;
import com.springframework.springmvc.services.ProductService;
import com.springframework.springmvc.services.UserService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class SpringJPABootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ProductService productService;
    private CustomerService customerService;
    private UserService userService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        loadProducts();
        loadUsersAndCustomers();
        loadCarts();
        loadOrderHistory();
    }

    private void loadOrderHistory() {
        List<User> users = (List<User>) userService.listAll();
        List<Product> products = (List<Product>) productService.listAll();

        users.forEach(user -> {
            Order order = new Order();
            order.setCustomer(user.getCustomer());

            products.forEach(product -> {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setProduct(product);
                orderDetail.setQuantity(1);
                order.addToOrderDetails(orderDetail);
            });
        });
    }

    private void loadCarts() {
        List<User> users = (List<User>) userService.listAll();
        List<Product> products = (List<Product>) productService.listAll();

        users.forEach(user -> {
            user.setCart(new Cart());
            CartDetail cartDetail = new CartDetail();
            cartDetail.setProduct(products.get(0));
            cartDetail.setQuantity(2);
            user.getCart().addCartDetail(cartDetail);
            userService.saveOrUpdate(user);
        });
    }

    public void loadProducts() {
        Product productOne = new Product();
        productOne.setId(1);
        productOne.setDescription("Product 1");
        productOne.setPrice(new BigDecimal("12.99"));
        productOne.setImageURL("http://example.com/product/{1}/images");
        productService.saveOrUpdate(productOne);

        Product productTwo = new Product();
        productTwo.setId(2);
        productTwo.setDescription("Product 2");
        productTwo.setPrice(new BigDecimal("9.99"));
        productTwo.setImageURL("http://example.com/product/{2}/images");
        productService.saveOrUpdate(productTwo);

        Product productThree = new Product();
        productThree.setId(3);
        productThree.setDescription("Product 3");
        productThree.setPrice(new BigDecimal("14.99"));
        productThree.setImageURL("http://example.com/product/{3}/images");
        productService.saveOrUpdate(productThree);

        Product productFour = new Product();
        productFour.setId(4);
        productFour.setDescription("Product 4");
        productFour.setPrice(new BigDecimal("5.99"));
        productFour.setImageURL("http://example.com/product/{4}/images");
        productService.saveOrUpdate(productFour);
    }

    public void loadUsersAndCustomers() {
        User userOne = new User();
        userOne.setUsername("drronidz");
        userOne.setPassword("12041994setif");

        Customer customerOne = new Customer();
        customerOne.setId(1);
        customerOne.setFirstName("John");
        customerOne.setLastName("Doe");
        customerOne.setBillingAddress(new Address());
        customerOne.getBillingAddress().setAddressLineOne("1 Main St");
        customerOne.getBillingAddress().setAddressLineTwo("2 Main St");
        customerOne.getBillingAddress().setCity("Miami");
        customerOne.getBillingAddress().setState("Florida");
        customerOne.getBillingAddress().setZipCode("33101");
        customerOne.setEmail("john.doe@springframework.org");
        customerOne.setPhoneNumber("305.333.0101");
        userOne.setCustomer(customerOne);

        userService.saveOrUpdate(userOne);

        User userTwo = new User();
        userTwo.setUsername("alcatraz");
        userTwo.setPassword("16061971ainazel");

        Customer customerTwo = new Customer();
        customerTwo.setId(2);
        customerTwo.setFirstName("Jane");
        customerTwo.setLastName("Doe");
        customerTwo.setBillingAddress(new Address());
        customerTwo.getBillingAddress().setAddressLineOne("3 Main St");
        customerTwo.getBillingAddress().setAddressLineTwo("4 Main St");
        customerTwo.getBillingAddress().setCity("Illinois");
        customerTwo.getBillingAddress().setState("Chicago");
        customerTwo.getBillingAddress().setZipCode("44101");
        customerTwo.setEmail("jane.doe@springframework.org");
        customerTwo.setPhoneNumber("405.333.0404");
        userTwo.setCustomer(customerTwo);

        userService.saveOrUpdate(userTwo);

        User userThree = new User();
        userThree.setUsername("user");
        userThree.setPassword("01011900london");

        Customer customerThree = new Customer();
        customerThree.setId(3);
        customerThree.setFirstName("Michel");
        customerThree.setLastName("Weston");
        customerThree.setBillingAddress(new Address());
        customerThree.getBillingAddress().setAddressLineOne("5 Main St");
        customerThree.getBillingAddress().setAddressLineTwo("6 Main St");
        customerThree.getBillingAddress().setCity("Illinois");
        customerThree.getBillingAddress().setState("Boston");
        customerThree.getBillingAddress().setZipCode("55101");
        customerThree.setEmail("michel.weston@springframework.org");
        customerThree.setPhoneNumber("905.666.0808");
        userThree.setCustomer(customerThree);

        userService.saveOrUpdate(userThree);
    }
}
