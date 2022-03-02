package com.springframework.springmvc.services.jpa;

/*
PROJECT NAME : 8. JPA
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 3/1/2022 9:41 PM
*/

import com.springframework.springmvc.domain.Product;
import com.springframework.springmvc.services.ProductService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Service
@Profile("jpa")
public class ProductServiceJPADAOImpl extends AbstractServiceJPADAO implements ProductService {


    @Override
    public List<Product> listAll() {
        EntityManager entityManager= entityManagerFactory.createEntityManager();

        return entityManager.createQuery("from Product", Product.class).getResultList();
    }

    @Override
    public Product getById(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.find(Product.class, id);
    }

    @Override
    public Product saveOrUpdate(Product domainObject) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Product savedProduct = entityManager.merge(domainObject);
        entityManager.getTransaction().commit();

        return savedProduct;
    }

    @Override
    public boolean delete(Integer id) {
        if (id == null || id == 0) {
            return false;
        } else {
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.find(Product.class, id));
            entityManager.getTransaction().commit();

            return true;
        }
    }
}
