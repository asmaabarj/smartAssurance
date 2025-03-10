package com.insurance.customer.dto;

import lombok.Data;

@Data
public class CustomerDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String adresse;
    private String telephone;
    private Long userId;
} 