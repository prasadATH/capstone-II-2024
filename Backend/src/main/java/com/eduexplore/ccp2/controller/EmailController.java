package com.eduexplore.ccp2.controller;

import com.eduexplore.ccp2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// EmailController.java
@RestController
@RequestMapping("/api")
@CrossOrigin
public class EmailController {

    @Autowired
    private StudentService emailService;

    @PostMapping("/forgot-password")
    public String sendOtp(@RequestBody EmailRequest emailRequest) {
        return emailService.sendOtp(emailRequest.getEmail(),emailRequest.getUsername());
        //return ResponseEntity.ok("OTP sent successfully!");
    }


    static class EmailRequest {
        private String email;
        private String username;

        public String getEmail() {
            return email;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
