package com.diniig.samples.spring_project.controllers.db;

import com.diniig.samples.spring_project.entities.Customer;
import com.diniig.samples.spring_project.repositories.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

@Controller
@RequestMapping(path = "/api/v2")
public class CustomerHibernateController {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @RequestMapping(method = RequestMethod.POST, path = "/customers")
    public ResponseEntity<String> addNewCustormer() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(new Customer(2, "name2"));
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }

        return ResponseEntity.ok("Hello world");
    }
}
