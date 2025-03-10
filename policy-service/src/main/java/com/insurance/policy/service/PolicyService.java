package com.insurance.policy.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.insurance.policy.client.CustomerClient;
import com.insurance.policy.dto.PolicyDTO;
import com.insurance.policy.model.Policy;
import com.insurance.policy.repository.PolicyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PolicyService {
    
    private final PolicyRepository policyRepository;
    private final CustomerClient customerClient;

    public Policy createPolicy(PolicyDTO policyDTO) {
        // Vérifier si le client existe
        customerClient.getCustomerById(policyDTO.getClientId());

        Policy policy = new Policy();
        policy.setType(policyDTO.getType());
        policy.setDateEffet(policyDTO.getDateEffet());
        policy.setDateExpiration(policyDTO.getDateExpiration());
        policy.setMontantCouverture(policyDTO.getMontantCouverture());
        policy.setClientId(policyDTO.getClientId());

        return policyRepository.save(policy);
    }

    public Policy getPolicy(Long id) {
        return policyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Police d'assurance non trouvée avec l'ID : " + id));
    }

    public List<Policy> getPoliciesByClientId(Long clientId) {
        // Vérifier si le client existe
        customerClient.getCustomerById(clientId);
        return policyRepository.findByClientId(clientId);
    }

    public Policy updatePolicy(Long id, PolicyDTO policyDTO) {
        Policy policy = getPolicy(id);
        
        policy.setType(policyDTO.getType());
        policy.setDateEffet(policyDTO.getDateEffet());
        policy.setDateExpiration(policyDTO.getDateExpiration());
        policy.setMontantCouverture(policyDTO.getMontantCouverture());

        return policyRepository.save(policy);
    }

    public void deletePolicy(Long id) {
        if (!policyRepository.existsById(id)) {
            throw new EntityNotFoundException("Police d'assurance non trouvée avec l'ID : " + id);
        }
        policyRepository.deleteById(id);
    }
} 