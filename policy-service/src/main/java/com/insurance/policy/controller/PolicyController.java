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

import com.insurance.policy.dto.PolicyDTO;
import com.insurance.policy.model.Policy;
import com.insurance.policy.service.PolicyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/policies")
@RequiredArgsConstructor
public class PolicyController {
    
    private final PolicyService policyService;

    @PostMapping
    public ResponseEntity<Policy> createPolicy(@RequestBody PolicyDTO policyDTO) {
        return ResponseEntity.ok(policyService.createPolicy(policyDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Policy> getPolicy(@PathVariable Long id) {
        return ResponseEntity.ok(policyService.getPolicy(id));
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<Policy>> getPoliciesByClientId(@PathVariable Long clientId) {
        return ResponseEntity.ok(policyService.getPoliciesByClientId(clientId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Policy> updatePolicy(@PathVariable Long id, @RequestBody PolicyDTO policyDTO) {
        return ResponseEntity.ok(policyService.updatePolicy(id, policyDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePolicy(@PathVariable Long id) {
        policyService.deletePolicy(id);
        return ResponseEntity.ok().build();
    }
} 