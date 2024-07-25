package com.eduexplore.ccp2.controller;
import com.eduexplore.ccp2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.eduexplore.ccp2.service.StudentServiceImpl.logger;

// EmailController.java
@RestController
@RequestMapping("/npw")
@CrossOrigin
public class NewPasswordController {

    @Autowired
    private StudentService otpService;

    @PostMapping("/NewPassword")
    public String newPassword(@RequestBody NewPasswordController.PasswordRequest pwRequest) {
        logger.info("Searched for: {}", pwRequest.getPassword());
        return otpService.addNewPassword(pwRequest.getPassword(),pwRequest.getUsername());

        //return ResponseEntity.ok("OTP sent successfully!");
    }

    static class PasswordRequest {
        private String password;
        private String username;

        public String getPassword() {
            return password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setPassword(String email) {
            this.password = email;
        }
    }
}