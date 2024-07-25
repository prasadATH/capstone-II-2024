package com.eduexplore.ccp2.repository;

import com.eduexplore.ccp2.model.Traveller;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Traveller,Integer> {
    Traveller findByUsername(String username);
    Traveller findByEmail(String email);
}