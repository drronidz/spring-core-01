package com.springframework.springmvc.services;

/*
PROJECT NAME : 6. Introducing Spring MVC
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 2/26/2022 11:03 PM
*/

import java.util.List;

public interface CRUDService<T> {
    List<?> listAll();
    T getById(Integer id);
    T saveOrUpdate(T domainObject);
    boolean delete(Integer id);
}
