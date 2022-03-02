package com.springframework.springmvc.services.jpa;

/*
PROJECT NAME : 9. JPA Entity Relationships
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 3/2/2022 3:06 PM
*/

import com.springframework.springmvc.domain.User;
import com.springframework.springmvc.services.UserService;
import com.springframework.springmvc.services.security.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Profile("jpa")
public class UserServiceJPADAOImpl extends AbstractServiceJPADAO implements UserService {

    private EncryptionService encryptionService;

    @Autowired
    public void setEncryptionService(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    @Override
    public List<User> listAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getById(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(User.class, id);
    }

    @Override
    public User saveOrUpdate(User domainObject) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        if(domainObject.getPassword() != null) {
            domainObject.setEncryptedPassword(encryptionService.encryptString(domainObject.getPassword()));
        }

        User savedUser = entityManager.merge(domainObject);
        entityManager.getTransaction().commit();

        return savedUser;
    }

    @Override
    public boolean delete(Integer id) {


        if (id == null || id == 0) {
            return false;
        } else {
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.find(User.class, id));
            entityManager.getTransaction().commit();
        }
        return false;
    }
}
