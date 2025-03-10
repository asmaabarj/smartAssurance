package com.insurance.policy.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.insurance.policy.dto.ClaimDTO;
import com.insurance.policy.model.Claim;
import com.insurance.policy.model.Policy;
import com.insurance.policy.repository.ClaimRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClaimService {
    
    private final ClaimRepository claimRepository;
    private final PolicyService policyService;

    public Claim createClaim(ClaimDTO claimDTO) {
        Policy policy = policyService.getPolicy(claimDTO.getPolicyId());

        Claim claim = new Claim();
        claim.setDate(claimDTO.getDate());
        claim.setDescription(claimDTO.getDescription());
        claim.setMontantReclame(claimDTO.getMontantReclame());
        claim.setMontantRembourse(claimDTO.getMontantRembourse());
        claim.setPolicy(policy);

        return claimRepository.save(claim);
    }

    public List<Claim> getClaimsByPolicyId(Long policyId) {
        // Vérifie si la police existe
        policyService.getPolicy(policyId);
        return claimRepository.findByPolicyId(policyId);
    }

    public Claim getClaim(Long id) {
        return claimRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sinistre non trouvé avec l'ID : " + id));
    }

    public Claim updateClaim(Long id, ClaimDTO claimDTO) {
        Claim claim = getClaim(id);
        
        claim.setDate(claimDTO.getDate());
        claim.setDescription(claimDTO.getDescription());
        claim.setMontantReclame(claimDTO.getMontantReclame());
        claim.setMontantRembourse(claimDTO.getMontantRembourse());

        return claimRepository.save(claim);
    }

    public void deleteClaim(Long id) {
        if (!claimRepository.existsById(id)) {
            throw new EntityNotFoundException("Sinistre non trouvé avec l'ID : " + id);
        }
        claimRepository.deleteById(id);
    }
} 