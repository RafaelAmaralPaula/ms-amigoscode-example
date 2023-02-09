package com.rafaelamaral.customer.controller;

import com.rafaelamaral.customer.model.Customer;
import com.rafaelamaral.customer.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Customer>> findAll(){
        var response = customerService.findAll();
        return ResponseEntity.ok().body(response);
    }

}
