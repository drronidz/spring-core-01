package com.springframework.springmvc.services.jpa;

/*
PROJECT NAME : 8. JPA
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 3/2/2022 2:33 PM
*/

import com.springframework.springmvc.domain.Customer;
import com.springframework.springmvc.domain.Product;
import com.springframework.springmvc.services.CustomerService;
import com.springframework.springmvc.services.security.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Service
@Profile("jpa")
public class CustomerServiceJPADAOImpl extends AbstractServiceJPADAO implements CustomerService {

    private EncryptionService encryptionService;

    @Autowired
    public void setEncryptionService(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    @Override
    public List<Customer> listAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.createQuery("from Customer", Customer.class).getResultList();
    }

    @Override
    public Customer getById(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.find(Customer.class, id);
    }

    @Override
    public Customer saveOrUpdate(Customer domainObject) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        if(domainObject.getUser() != null && domainObject.getUser().getPassword() != null) {
            domainObject
                    .getUser()
                    .setEncryptedPassword(encryptionService.encryptString(domainObject.getUser().getPassword()));
        }
        Customer savedCustomer = entityManager.merge(domainObject);
        entityManager.getTransaction().commit();

        return savedCustomer;
    }

    @Override
    public boolean delete(Integer id) {
        if (id == null || id == 0) {
            return false;
        }
        else {
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.find(Customer.class, id));
            entityManager.getTransaction().commit();

            return true;
        }

    }
}
