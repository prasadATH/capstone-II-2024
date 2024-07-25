package com.eduexplore.ccp2.service;

import com.eduexplore.ccp2.controller.AuthController;
import com.eduexplore.ccp2.model.ServiceProvider;
import com.eduexplore.ccp2.repository.ServiceProviderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceProviderImpl implements ServiceProviderService{

    @Autowired
    private ServiceProviderRepository serviceProviderRepository;
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Override
    public ServiceProvider saveServiceProvider(ServiceProvider serviceProvider) {
        return serviceProviderRepository.save(serviceProvider);
    }
    @Override
    public ServiceProvider loginServiceProvider(String username, String password) {
        ServiceProvider serviceProvider = serviceProviderRepository.findByUsername(username);
        logger.info("Searched for: {}"+ username+ password);

        if(serviceProvider != null && serviceProvider.getPassword().equals(password)){
            return serviceProvider;
        }
        return null;
    }

    @Override
    public ServiceProvider getServiceProviderDetailsByUsername(String username) {
        return serviceProviderRepository.findByUsername(username);
    }

    @Override
    public ServiceProvider updateServiceProvider(String username, ServiceProvider updatedServiceProvider) {
        ServiceProvider existingServiceProvider = serviceProviderRepository.findByUsername(username);
        if (existingServiceProvider != null) {
            existingServiceProvider.setName(updatedServiceProvider.getName());
            existingServiceProvider.setEmail(updatedServiceProvider.getEmail());
            existingServiceProvider.setServiceType(updatedServiceProvider.getServiceType());
            existingServiceProvider.setServiceProviderDescription(updatedServiceProvider.getServiceProviderDescription());
            return serviceProviderRepository.save(existingServiceProvider);
        }
        return null;
    }
    };

