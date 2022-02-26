package com.springframework.springmvc.services;

/*
PROJECT NAME : 6. Introducing Spring MVC
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 2/26/2022 4:49 PM
*/

import com.springframework.springmvc.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    Product getProductById(Integer id);
    Product saveOrUpdateProduct(Product product);
    boolean deleteProduct(Integer id);
}
