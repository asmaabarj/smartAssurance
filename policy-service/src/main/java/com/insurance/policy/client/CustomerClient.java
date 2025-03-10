package com.insurance.policy.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.insurance.policy.dto.CustomerDTO;

@FeignClient(name = "customer-service")
public interface CustomerClient {
    
    @GetMapping("/api/customers/{id}")
    CustomerDTO getCustomerById(@PathVariable("id") Long id);
} 