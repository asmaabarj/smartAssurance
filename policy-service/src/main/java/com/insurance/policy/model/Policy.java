package com.insurance.policy.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "policies")
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    private PolicyType type;
    
    private LocalDate dateEffet;
    private LocalDate dateExpiration;
    private BigDecimal montantCouverture;
    private Long clientId;
    
    @OneToMany(mappedBy = "policy", cascade = CascadeType.ALL)
    private List<Claim> claims = new ArrayList<>();
} 