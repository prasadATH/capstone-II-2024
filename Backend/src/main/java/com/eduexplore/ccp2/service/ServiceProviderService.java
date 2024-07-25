package com.eduexplore.ccp2.service;


import com.eduexplore.ccp2.model.ServiceProvider;

public interface ServiceProviderService {

    public ServiceProvider saveServiceProvider(ServiceProvider serviceProvider);
    public ServiceProvider loginServiceProvider(String username, String password);

    public ServiceProvider getServiceProviderDetailsByUsername(String username);

    public ServiceProvider updateServiceProvider(String username, ServiceProvider updatedServiceProvider);


}
