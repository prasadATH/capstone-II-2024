package com.ccp.demo.controller;
import com.ccp.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// OtpController.java
@RestController
@RequestMapping("/Otp")
@CrossOrigin
public class OtpController {
    @Autowired
    private StudentService otpService;

    @PostMapping("/Otp-verify")
    public String verifyOtp(@RequestBody OtpController.OtpRequest otpRequest) {
        return otpService.VerifyOtp(otpRequest.getOtp(),otpRequest.getUsername());
        //return ResponseEntity.ok("OTP sent successfully!");
    }


    static class OtpRequest {
        private String otp;
        private String username;

        public String getOtp() {
            return otp;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setOtp(String email) {
            this.otp = email;
        }
    }
}
