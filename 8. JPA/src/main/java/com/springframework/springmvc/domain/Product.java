package com.springframework.springmvc.domain;

/*
PROJECT NAME : 6. Introducing Spring MVC
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 2/26/2022 4:47 PM
*/

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Product implements DomainObject{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // GenerationType.AUTO good for (h2 & mysql)
    // GenerationType.SEQUENCE good for (oracle db)
    private Integer id;
    private String description;
    private BigDecimal price;
    private String imageURL;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
