package com.cakir.authserver.services;

import com.cakir.authserver.models.Customer;
import com.cakir.authserver.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final CustomerRepository customerRepository;
    private final AuthorityService authorityService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEmail(username).orElseThrow(() -> new
                UsernameNotFoundException("User details not found for the user: " + username));

        if (customer.getAuthorities().isEmpty()) {
            customer.setAuthorities(authorityService.getAuthoritiesByCustomerId(customer.getId()));
        }

        List<GrantedAuthority> authorities = customer.getAuthorities().stream().map(authority -> new
                SimpleGrantedAuthority(authority.getName())).collect(Collectors.toList());

        return new User(customer.getEmail(), customer.getPwd(), authorities);
    }
}
