package com.joelcodes.studentsystem.repository;

import com.joelcodes.studentsystem.model.Student;
import com.joelcodes.studentsystem.model.Traveller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Traveller,Integer> {
    Traveller findByUsername(String username);
    Traveller findByEmail(String email);
}