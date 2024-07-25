package com.ccp.demo.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ccp.demo.service.StudentService;
import com.ccp.demo.model.Traveller;
@RestController
@RequestMapping("/auth")
@CrossOrigin
public class LoginController {
    @Autowired
    private StudentService studentService;

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
                studentService.saveTraveller(traveller);
                return ResponseEntity.ok("ok");
            }else{
                return ResponseEntity.ok("Username or password is incorrect!");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred while adding the new traveller");
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
