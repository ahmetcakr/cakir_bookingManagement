package com.cakir.authserver.services;

import com.cakir.authserver.models.Authority;
import com.cakir.authserver.repositories.AuthorityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthorityService {
    private final AuthorityRepository authorityRepository;

    public Set<Authority> getAuthoritiesByCustomerId(long customerId) {
        return authorityRepository.findByCustomerId(customerId)
                .orElseThrow(() ->
                        new RuntimeException("No authorities found for the customer with id: " + customerId));
    }
}
