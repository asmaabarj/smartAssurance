package com.insurance.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsByUserId(Long userId);
} 