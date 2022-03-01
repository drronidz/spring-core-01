package com.springframework.springmvc.bootstrap;

/*
PROJECT NAME : 8. JPA
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 3/1/2022 11:19 PM
*/

import com.springframework.springmvc.domain.Product;
import com.springframework.springmvc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SpringJPABootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadProducts();
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
}
