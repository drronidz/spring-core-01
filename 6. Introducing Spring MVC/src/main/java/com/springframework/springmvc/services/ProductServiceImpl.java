package com.springframework.springmvc.services;

/*
PROJECT NAME : 6. Introducing Spring MVC
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 2/26/2022 4:49 PM
*/

import com.springframework.springmvc.domain.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    private Map<Integer, Product> products;

    public ProductServiceImpl() {
        products = new HashMap<>();
        loadProducts();
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product getProductById(Integer id) {
        return products.get(id);
    }

    private void loadProducts() {
        Product productOne = new Product();
        productOne.setId(1);
        productOne.setDescription("Product 1");
        productOne.setPrice(new BigDecimal("12.99"));
        productOne.setImageURL("http://example.com/product1");
        products.put(1, productOne);

        Product productTwo = new Product();
        productTwo.setId(2);
        productTwo.setDescription("Product 2");
        productTwo.setPrice(new BigDecimal("14.99"));
        productTwo.setImageURL("http://example.com/product2");
        products.put(2, productTwo);

        Product productThree = new Product();
        productThree.setId(3);
        productThree.setDescription("Product 3");
        productThree.setPrice(new BigDecimal("9.99"));
        productThree.setImageURL("http://example.com/product3");
        products.put(3, productThree);

        Product productFour = new Product();
        productFour.setId(4);
        productFour.setDescription("Product 4");
        productFour.setPrice(new BigDecimal("19.99"));
        productFour.setImageURL("http://example.com/product4");
        products.put(4, productFour);


    }
}
