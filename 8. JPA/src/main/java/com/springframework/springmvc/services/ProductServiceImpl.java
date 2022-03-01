package com.springframework.springmvc.services;

/*
PROJECT NAME : 6. Introducing Spring MVC
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 2/26/2022 4:49 PM
*/

import com.springframework.springmvc.domain.DomainObject;
import com.springframework.springmvc.domain.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
@Profile("map")
public class ProductServiceImpl extends AbstractMapService implements ProductService{

    public ProductServiceImpl() {
        loadDomainObjects();
    }

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public Product getById(Integer id) {
        return (Product) super.getById(id);
    }

    @Override
    public Product saveOrUpdate(Product domainObject) {
        return (Product) super.saveOrUpdate(domainObject);
    }

    @Override
    public boolean delete(Integer id) {
        return super.delete(id);
    }

    @Override
    protected void loadDomainObjects() {
        domainMap = new HashMap<>();

        Product productOne = new Product();
        productOne.setId(1);
        productOne.setDescription("Product 1");
        productOne.setPrice(new BigDecimal("12.99"));
        productOne.setImageURL("http://example.com/product/{1}/images");
        domainMap.put(1, productOne);

        Product productTwo = new Product();
        productTwo.setId(2);
        productTwo.setDescription("Product 2");
        productTwo.setPrice(new BigDecimal("9.99"));
        productTwo.setImageURL("http://example.com/product/{2}/images");
        domainMap.put(2, productTwo);

        Product productThree = new Product();
        productThree.setId(3);
        productThree.setDescription("Product 3");
        productThree.setPrice(new BigDecimal("14.99"));
        productThree.setImageURL("http://example.com/product/{3}/images");
        domainMap.put(3, productThree);

        Product productFour = new Product();
        productFour.setId(4);
        productFour.setDescription("Product 4");
        productFour.setPrice(new BigDecimal("5.99"));
        productFour.setImageURL("http://example.com/product/{4}/images");
        domainMap.put(4, productFour);
    }
}
