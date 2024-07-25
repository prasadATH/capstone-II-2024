package com.eduexplore.ccp2.controller;

import com.eduexplore.ccp2.model.ServiceProvider;
import com.eduexplore.ccp2.service.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/serviceProvider")
@CrossOrigin
public class ServiceProviderController {

    @Autowired
    private ServiceProviderService serviceProviderService;
    @GetMapping("/{username}")
    public ResponseEntity<ServiceProvider> getServiceProviderByUsername(@PathVariable String username) {
        try {
            ServiceProvider serviceProvider = serviceProviderService.getServiceProviderDetailsByUsername(username);
            return ResponseEntity.ok(serviceProvider);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping("/updateProfile/{username}")
    public ResponseEntity<ServiceProvider> updateServiceProvider(@PathVariable("username") String username,
                                                                 @RequestBody ServiceProvider updatedServiceProvider){
        try{
            ServiceProvider existingServiceProvider = serviceProviderService.updateServiceProvider(username,updatedServiceProvider);
            if(existingServiceProvider!=null){
                return ResponseEntity.ok(existingServiceProvider);
            }else{
                return ResponseEntity.notFound().build();
            }
        }
        catch (Exception e){
            return ResponseEntity.status(500).body(null);
        }
    }

}
