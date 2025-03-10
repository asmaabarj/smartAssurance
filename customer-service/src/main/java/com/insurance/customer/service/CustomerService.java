package com.insurance.customer.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.insurance.customer.dto.CustomerDTO;
import com.insurance.customer.model.Customer;
import com.insurance.customer.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {
    
    private final CustomerRepository customerRepository;

    public Customer createCustomer(CustomerDTO customerDTO) {
        if (customerRepository.existsByUserId(customerDTO.getUserId())) {
            throw new RuntimeException("Un client existe déjà pour cet utilisateur");
        }

        Customer customer = new Customer();
        customer.setNom(customerDTO.getNom());
        customer.setPrenom(customerDTO.getPrenom());
        customer.setEmail(customerDTO.getEmail());
        customer.setAdresse(customerDTO.getAdresse());
        customer.setTelephone(customerDTO.getTelephone());
        customer.setUserId(customerDTO.getUserId());

        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client non trouvé avec l'ID : " + id));
    }

    public Customer updateCustomer(Long id, CustomerDTO customerDTO) {
        Customer customer = getCustomerById(id);
        
        customer.setNom(customerDTO.getNom());
        customer.setPrenom(customerDTO.getPrenom());
        customer.setEmail(customerDTO.getEmail());
        customer.setAdresse(customerDTO.getAdresse());
        customer.setTelephone(customerDTO.getTelephone());

        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new EntityNotFoundException("Client non trouvé avec l'ID : " + id);
        }
        customerRepository.deleteById(id);
    }
} 