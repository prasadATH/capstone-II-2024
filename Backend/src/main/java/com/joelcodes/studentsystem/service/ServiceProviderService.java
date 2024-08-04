package com.joelcodes.studentsystem.service;

import com.joelcodes.studentsystem.model.ServiceProvider;

public interface ServiceProviderService {
    public ServiceProvider saveServiceProvider(ServiceProvider serviceProvider);
    public ServiceProvider loginServiceProvider(String username, String password);

//    public ServiceProvider getServiceProviderDetailsByUsername(String username);

    public ServiceProvider getServiceProviderDetailsById(int id);
    public ServiceProvider updateServiceProvider(String username, ServiceProvider updatedServiceProvider);

    boolean ifUsernameExists(String username);
    boolean ifEmailExists(String email);

    public String sendOtp(String email,String username);

    public String VerifyOtp(String otp,String username);
    public String addNewPassword(String password,String username);

}
