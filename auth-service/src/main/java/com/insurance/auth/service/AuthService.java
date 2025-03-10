package com.insurance.auth.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.insurance.auth.dto.AuthRequest;
import com.insurance.auth.dto.AuthResponse;
import com.insurance.auth.model.Role;
import com.insurance.auth.model.User;
import com.insurance.auth.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword())
        );
        
        User user = userRepository.findByLogin(request.getLogin())
            .orElseThrow(() -> new RuntimeException("User not found"));
            
        String token = jwtService.generateToken(user.getLogin());
        
        return AuthResponse.builder()
            .token(token)
            .userId(user.getId())
            .build();
    }

    public User register(AuthRequest request) {
        if (userRepository.findByLogin(request.getLogin()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        User user = new User();
        user.setLogin(request.getLogin());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setActive(true);
        user.getRoles().add(Role.CLIENT);
        
        return userRepository.save(user);
    }
} 