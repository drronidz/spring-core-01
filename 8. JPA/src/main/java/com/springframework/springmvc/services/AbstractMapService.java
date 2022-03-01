package com.springframework.springmvc.services;

/*
PROJECT NAME : 6. Introducing Spring MVC
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 2/26/2022 10:56 PM
*/

import com.springframework.springmvc.domain.DomainObject;

import java.util.*;

public abstract class AbstractMapService {
    protected Map<Integer, DomainObject> domainMap;

    public AbstractMapService() {
        domainMap = new HashMap<>();
    }

    public List<DomainObject> listAll() {
        return new ArrayList<>(domainMap.values());
    }

    public DomainObject getById(Integer id) {
        return domainMap.get(id);
    }

    public DomainObject saveOrUpdate(DomainObject domainObject) {
        if (domainObject != null) {
            if (domainObject.getId() == null) {
                domainObject.setId(getNextKey());
            }
            domainMap.put(domainObject.getId(), domainObject);
            return domainObject;
        } else {
            throw new RuntimeException("Object can't be null");
        }
    }

    public boolean delete(Integer id) {
        if (id == null) {
            throw new RuntimeException("Id can't be null");
        } else {
            domainMap.remove(id);
            return true;
        }
    }

    private Integer getNextKey() {
        return Collections.max(domainMap.keySet()) + 1;
    }

    protected abstract void loadDomainObjects();
}
