package com.eduexplore.ccp2.service;

import com.eduexplore.ccp2.model.Traveller;

public interface StudentService {
    public Traveller saveTraveller(Traveller traveller);

    public Traveller loginTraveller(String username, String password);

    public String sendOtp(String email,String username);

    public String VerifyOtp(String otp,String username);

    public String addNewPassword(String password,String username);

    //public void sendEmail(String email, String otp);

}
