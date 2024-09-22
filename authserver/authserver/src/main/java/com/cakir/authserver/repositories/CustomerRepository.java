package com.cakir.authserver.repositories;

import com.cakir.authserver.models.Customer;
import org.hibernate.FetchMode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);
}
