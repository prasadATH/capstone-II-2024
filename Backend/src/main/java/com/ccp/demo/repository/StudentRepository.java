package com.ccp.demo.repository;

import com.ccp.demo.model.Student;
import com.ccp.demo.model.Traveller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Traveller,Integer> {
    Traveller findByUsername(String username);
    Traveller findByEmail(String email);
}