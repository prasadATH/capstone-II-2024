package com.joelcodes.studentsystem.controller;
import com.joelcodes.studentsystem.service.ServiceProviderService;
import com.joelcodes.studentsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.joelcodes.studentsystem.service.StudentServiceImpl.logger;

// EmailController.java
@RestController
@RequestMapping("/npw")
@CrossOrigin
public class NewPasswordController {

    @Autowired
    private StudentService otpService;
    private ServiceProviderService serviceProviderNewPwService;

    @PostMapping("/NewPassword")
    public String newPassword(@RequestBody NewPasswordController.PasswordRequest pwRequest) {
        logger.info("Searched for: {}", pwRequest.getPassword());
        return otpService.addNewPassword(pwRequest.getPassword(),pwRequest.getUsername());

        //return ResponseEntity.ok("OTP sent successfully!");
    }

    @PostMapping("/serviceProvider/NewPassword")
    public String serviceProviderNewPassword(@RequestBody NewPasswordController.PasswordRequest pwRequest) {
        logger.info("Searched for: {}", pwRequest.getPassword());
        return serviceProviderNewPwService.addNewPassword(pwRequest.getPassword(),pwRequest.getUsername());

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
