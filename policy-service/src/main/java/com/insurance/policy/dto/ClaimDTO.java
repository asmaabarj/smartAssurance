package com.insurance.policy.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class ClaimDTO {
    private Long id;
    private LocalDate date;
    private String description;
    private BigDecimal montantReclame;
    private BigDecimal montantRembourse;
    private Long policyId;
} 