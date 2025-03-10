package com.insurance.policy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.policy.model.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Long> {
    List<Policy> findByClientId(Long clientId);
} 