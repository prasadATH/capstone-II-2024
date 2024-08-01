package com.joelcodes.studentsystem.service;

import com.joelcodes.studentsystem.model.Course;

import java.util.List;

public interface CourseService {
    public List<Course> getFilteredCourses(String search, String priceRange, String eventDuration, String location, String educationalFocus, String learningOutcome);
    public void saveCourse(Course course);

    void deleteCourseById(int id); // Add this line

    Course getCourseById(int id);

    public List<Course> getAllCourses();
    void updateCourseImage(int id, String imageUrl);
}
