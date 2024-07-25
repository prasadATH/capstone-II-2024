package com.eduexplore.ccp2.repository;

import com.eduexplore.ccp2.model.ServiceProvider;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceProviderRepository extends CrudRepository<ServiceProvider,Integer> {

    ServiceProvider findByUsername(String username);
}
