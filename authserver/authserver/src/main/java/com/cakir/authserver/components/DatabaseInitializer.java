package com.cakir.authserver.components;

import com.cakir.authserver.models.Authority;
import com.cakir.authserver.models.Customer;
import com.cakir.authserver.repositories.AuthorityRepository;
import com.cakir.authserver.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class DatabaseInitializer implements CommandLineRunner {
    private final AuthorityRepository authorityRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {

        if (customerRepository.findByEmail("admin@cakir.com").isPresent()) {
            return;
        }

        Customer adminCustomer = new Customer();
        adminCustomer.setEmail("admin@cakir.com");
        adminCustomer.setName("Admin");
        adminCustomer.setPwd("{bcrypt}$2a$12$kPVgToOEcUff2FBBCoZcPeibuR7CYjdFBYPvTbSj9RdOVn3AT0gmy"); //admin
        adminCustomer.setMobileNumber("1234567890");
        adminCustomer.setRole("admin");
        adminCustomer.setCreateDt(Date.from(new Date().toInstant()));

        adminCustomer = customerRepository.save(adminCustomer);

        Authority admninAuthority = new Authority();
        admninAuthority.setName("ROLE_ADMIN");
        admninAuthority.setCustomer(adminCustomer);

        authorityRepository.save(admninAuthority);
    }
}
