package com.joelcodes.studentsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String image;  // Change Blob to String
    private String name;
    private String price;
    private String standard;
    private String location;
    private String educationalFocus;
    private String learningOutcome;
    private String eventDuration;

    // Constructors
    public Course() {}

    public Course(String image, String name, String price, String standard, String location, String educationalFocus, String learningOutcome, String eventDuration) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.standard = standard;
        this.location = location;
        this.educationalFocus = educationalFocus;
        this.learningOutcome = learningOutcome;
        this.eventDuration = eventDuration;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEducationalFocus() {
        return educationalFocus;
    }

    public void setEducationalFocus(String educationalFocus) {
        this.educationalFocus = educationalFocus;
    }

    public String getLearningOutcome() {
        return learningOutcome;
    }

    public void setLearningOutcome(String learningOutcome) {
        this.learningOutcome = learningOutcome;
    }

    public String getEventDuration() {
        return eventDuration;
    }

    public void setEventDuration(String eventDuration) {
        this.eventDuration = eventDuration;
    }
}
