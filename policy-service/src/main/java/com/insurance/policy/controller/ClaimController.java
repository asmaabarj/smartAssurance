package com.insurance.policy.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.policy.dto.ClaimDTO;
import com.insurance.policy.model.Claim;
import com.insurance.policy.service.ClaimService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/claims")
@RequiredArgsConstructor
public class ClaimController {
    
    private final ClaimService claimService;

    @PostMapping
    public ResponseEntity<Claim> createClaim(@RequestBody ClaimDTO claimDTO) {
        return ResponseEntity.ok(claimService.createClaim(claimDTO));
    }

    @GetMapping("/policy/{policyId}")
    public ResponseEntity<List<Claim>> getClaimsByPolicyId(@PathVariable Long policyId) {
        return ResponseEntity.ok(claimService.getClaimsByPolicyId(policyId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Claim> getClaim(@PathVariable Long id) {
        return ResponseEntity.ok(claimService.getClaim(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Claim> updateClaim(@PathVariable Long id, @RequestBody ClaimDTO claimDTO) {
        return ResponseEntity.ok(claimService.updateClaim(id, claimDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClaim(@PathVariable Long id) {
        claimService.deleteClaim(id);
        return ResponseEntity.ok().build();
    }
} 