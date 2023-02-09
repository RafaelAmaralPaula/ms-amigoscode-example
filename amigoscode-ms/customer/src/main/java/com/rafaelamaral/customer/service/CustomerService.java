package com.rafaelamaral.customer.service;

import com.rafaelamaral.customer.controller.FraudCheckResponse;
import com.rafaelamaral.customer.model.Customer;
import com.rafaelamaral.customer.repository.CustomerRepository;
import com.rafaelamaral.customer.controller.CustomerRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService{
    private final CustomerRepository customerRepository;

    private final RestTemplate restTemplate;

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
       var fraudCheckResponse =  restTemplate.getForObject(
                "http://localhost:8081/frauds/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );

       if(fraudCheckResponse.isFraudster()){
           throw new IllegalStateException("fraudster");
       }
    }
}
