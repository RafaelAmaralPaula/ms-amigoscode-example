package com.rafaelamaral.customer.service;

import com.rafaelamaral.customer.controller.CustomerRequest;
import com.rafaelamaral.customer.model.Customer;
import com.rafaelamaral.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record CustomerService(CustomerRepository customerRepository) {

    public Iterable<Customer> findAll(){
        return customerRepository.findAll();
    }

    public void registrationCustomer(CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                                    .firstName(customerRequest.firstName())
                                    .lastName(customerRequest.lastName())
                                    .email(customerRequest.email())
                                    .build();

        customerRepository.save(customer);
    }
}
