package com.insurance.policy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.policy.model.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Long> {
    List<Claim> findByPolicyId(Long policyId);
} 