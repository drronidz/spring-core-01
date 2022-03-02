package com.springframework.springmvc.services.map;

/*
PROJECT NAME : 9. JPA Entity Relationships
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 3/2/2022 3:04 PM
*/

import com.springframework.springmvc.domain.DomainObject;
import com.springframework.springmvc.domain.User;
import com.springframework.springmvc.services.UserService;

import java.util.List;

public class UserServiceImpl extends AbstractMapService implements UserService {

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public User getById(Integer id) {
        return (User) super.getById(id);
    }

    @Override
    public User saveOrUpdate(User domainObject) {
        return (User) super.saveOrUpdate(domainObject);
    }

    @Override
    public boolean delete(Integer id) {
        return super.delete(id);
    }

    @Override
    protected void loadDomainObjects() {

    }
}
