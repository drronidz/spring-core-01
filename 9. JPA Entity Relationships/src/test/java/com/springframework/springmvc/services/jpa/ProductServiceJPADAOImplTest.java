package com.springframework.springmvc.services.jpa;

import com.springframework.springmvc.config.JPAIntegrationConfig;
import com.springframework.springmvc.domain.Product;
import com.springframework.springmvc.services.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;


/*
PROJECT NAME : 8. JPA
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 3/2/2022 1:45 PM
*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JPAIntegrationConfig.class)
@ActiveProfiles("jpa")
public class ProductServiceJPADAOImplTest {


    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Test
    public void listMethodTest() throws Exception {
        List<Product> products = (List<Product>) productService.listAll();

        assertEquals(products.size(), 4);
    }
}