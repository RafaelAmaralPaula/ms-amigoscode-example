package com.rafaelamaral.customer.controller;

import com.rafaelamaral.customer.model.Customer;
import com.rafaelamaral.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/customers")
public record CustomerController(CustomerService customerService) {


    @PostMapping
    public void registerCustomer(@RequestBody  CustomerRequest customerRequest){
      log.info("new customer registration {} " , customerRequest);
      customerService.registrationCustomer(customerRequest);
    }

    @GetMapping
    public ResponseEntity<Iterable<Customer>> findAll(){
        var response = customerService.findAll();
        return ResponseEntity.ok().body(response);
    }

}
