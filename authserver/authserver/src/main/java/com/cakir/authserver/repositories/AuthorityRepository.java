package com.cakir.authserver.repositories;

import com.cakir.authserver.models.Authority;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface AuthorityRepository extends CrudRepository<Authority, Long> {
    Optional<Set<Authority>> findByCustomerId(long customerId);
}
