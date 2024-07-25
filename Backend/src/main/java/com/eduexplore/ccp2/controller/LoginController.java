package com.eduexplore.ccp2.controller;



import com.eduexplore.ccp2.model.Traveller;
import com.eduexplore.ccp2.model.ServiceProvider;
import com.eduexplore.ccp2.service.ServiceProviderService;

import com.eduexplore.ccp2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class LoginController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private ServiceProviderService serviceProviderService;

    @PostMapping("/signup")
    public ResponseEntity<String> add(@RequestBody Traveller traveller) {
        try {
            studentService.saveTraveller(traveller);
            return ResponseEntity.ok("ok");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred while adding the new traveller");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {

        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        Traveller traveller = studentService.loginTraveller(username, password);

        try {
            if (traveller != null) {
                return ResponseEntity.ok("Username or password is incorrect!");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred while adding the new traveller");
        }
    }

    @PostMapping("/serviceProviderSignup")
    public ResponseEntity<String> add(@RequestBody ServiceProvider serviceProvider) {
        try {
            serviceProviderService.saveServiceProvider(serviceProvider);
            return ResponseEntity.ok("ok");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred while adding the new service provider");
        }
    }


    @PostMapping("/serviceProviderLogin")
    public ResponseEntity<String> serviceProivderLogin(@RequestBody LoginRequest loginRequest) {

        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        ServiceProvider serviceProvider = serviceProviderService.loginServiceProvider(username,password);

        try {
            if (serviceProvider != null) {

                return ResponseEntity.ok("ok");
            }else{
                return ResponseEntity.ok("Username or password is incorrect!");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred while login in a service provider");
        }
    }

    // Inner class representing the login request JSON structure
    static class LoginRequest {
        private String username;
        private String password;

        // Getters and setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

}
