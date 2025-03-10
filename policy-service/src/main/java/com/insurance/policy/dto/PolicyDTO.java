package com.insurance.policy.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.insurance.policy.model.PolicyType;

import lombok.Data;

@Data
public class PolicyDTO {
    private Long id;
    private PolicyType type;
    private LocalDate dateEffet;
    private LocalDate dateExpiration;
    private BigDecimal montantCouverture;
    private Long clientId;
} 