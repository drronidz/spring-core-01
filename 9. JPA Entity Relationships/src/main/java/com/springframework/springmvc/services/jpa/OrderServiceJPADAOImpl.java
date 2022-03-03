package com.springframework.springmvc.services.jpa;

/*
PROJECT NAME : 9. JPA Entity Relationships
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 3/4/2022 12:21 AM
*/

import com.springframework.springmvc.domain.Order;
import com.springframework.springmvc.services.OrderService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Profile("jpa")
public class OrderServiceJPADAOImpl extends AbstractServiceJPADAO implements OrderService {
    @Override
    public List<?> listAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.createQuery("from Order", Order.class).getResultList();
    }

    @Override
    public Order getById(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.find(Order.class, id);
    }

    @Override
    public Order saveOrUpdate(Order domainObject) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Order savedOrder = entityManager.merge(domainObject);
        entityManager.getTransaction().commit();

        return savedOrder;
    }

    @Override
    public boolean delete(Integer id) {
        if (id == 0 || id == null) {
            return false;
        } else {
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.find(Order.class, id));
            entityManager.getTransaction().commit();

            return true;
        }
    }
}
