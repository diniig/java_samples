package com.diniig.samples.spring_project.repositories;

import com.diniig.samples.spring_project.entities.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    
}
