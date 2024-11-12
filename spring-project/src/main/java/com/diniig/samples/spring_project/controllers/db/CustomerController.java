package com.diniig.samples.spring_project.controllers.db;

import com.diniig.samples.spring_project.entities.Customer;
import com.diniig.samples.spring_project.repositories.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping(path = "/api/v1")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(method = RequestMethod.POST, path = "/customers")
    // @Transactional
    public ResponseEntity<String> addNewCustormer() {

        customerRepository.save(new Customer(1, "name"));
        return ResponseEntity.ok("Hello world");
    }
}
