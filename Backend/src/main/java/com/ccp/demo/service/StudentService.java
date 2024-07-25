package com.ccp.demo.service;

import com.ccp.demo.model.Student;
import com.ccp.demo.model.Traveller;

import java.util.List;

public interface StudentService {
    public Traveller saveTraveller(Traveller traveller);

    public Traveller loginTraveller(String username, String password);

    public String sendOtp(String email,String username);

    public String VerifyOtp(String otp,String username);

    public String addNewPassword(String password,String username);

    //public void sendEmail(String email, String otp);

}
