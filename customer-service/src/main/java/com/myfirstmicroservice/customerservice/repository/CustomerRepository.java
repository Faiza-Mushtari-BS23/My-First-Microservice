package com.myfirstmicroservice.customerservice.repository;

import com.myfirstmicroservice.customerservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT c FROM Customer c WHERE c.id = :id")
    Customer findByOnlyId(Long id);

}