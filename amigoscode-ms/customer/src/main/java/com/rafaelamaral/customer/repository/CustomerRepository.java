package com.rafaelamaral.customer.repository;

import com.rafaelamaral.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer , Integer> {
}
