package com.joelcodes.studentsystem.service;

import com.joelcodes.studentsystem.model.Traveller;
import com.joelcodes.studentsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

@Service
public class StudentServiceImpl implements StudentService {
    public static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public Traveller saveTraveller(Traveller traveller) {
        return studentRepository.save(traveller);
    }

    @Override
    public Traveller loginTraveller(String username, String password) {
        Traveller traveller = studentRepository.findByUsername(username);
        logger.info("Searched for: {}" + username + password);

        // logger.info("Searched for: {}",
        // studentRepository.findByUsername(username).getUsername()+
        // studentRepository.findByUsername(username).getPassword());
        if (traveller != null && traveller.getPassword().equals(password)) {
            return traveller;
        }
        return null; // Return null if traveller is not found or password does not match
    }

    @Override
    public String sendOtp(String email, String username) {
        // Verify email input against your database
        Traveller traveller = studentRepository.findByEmail(email);
        Traveller traveller2 = studentRepository.findByUsername(username);

        // if (traveller != null && traveller.getEmail().equals(email))
        if (traveller != null && traveller2.getEmail().equals(email)) { // This means that the email is equal to the
                                                                        // added usernames email so its the same person
            String otp = generateOtp(10); // implement this function to generate a random OTP
            // sendEmail(email, otp);
            traveller2.setOtp(otp);
            studentRepository.save(traveller2);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("OTP on Forgot Password");
            message.setText(otp);

            javaMailSender.send(message);

            return otp;

        } else {
            throw new RuntimeException("Invalid email address.");
        }

        // Generate OTP and send to user's email address

    }

    @Override
    public String VerifyOtp(String otp, String username) {
        Traveller traveller = studentRepository.findByUsername(username);

        if (traveller != null && traveller.getOtp().equals(otp)) { // This means that the email is equal to the added
                                                                   // usernames email so its the same person

            String message = "OTP is correct";
            return message;

        } else {
            throw new RuntimeException("Invalid email address.");
        }
    }

    @Override
    public String addNewPassword(String password, String username) {
        Traveller traveller = studentRepository.findByUsername(username);
        traveller.setPassword(password);
        studentRepository.save(traveller);
        logger.info("Searched for pw in implementation: {}", password);

        String message = "password Changed SUCCESSFULLY!!!";
        return password;
    }

    private String generateOtp(int length) {
        // Create a Random instance
        Random rand = new Random();

        // Create a StringBuilder to store the OTP
        StringBuilder otp = new StringBuilder(length);

        // Loop through the desired length
        for (int i = 0; i < length; i++) {
            // Generate a random digit between 0 and 9
            int digit = rand.nextInt(10);

            // Append the digit to the OTP
            otp.append(digit);
        }

        // Return the generated OTP as a string
        return otp.toString();
    }


    // Return the generated OTP as a string

}
