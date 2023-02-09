package com.rafaelamaral.customer.service;

import com.rafaelamaral.customer.model.Customer;
import com.rafaelamaral.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public Iterable<Customer> findAll(){
        return customerRepository.findAll();
    }

}
