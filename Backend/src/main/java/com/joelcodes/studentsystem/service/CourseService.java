package com.joelcodes.studentsystem.service;

import com.joelcodes.studentsystem.model.Course;

import java.util.List;

public interface CourseService {
    public List<Course> getFilteredCourses(String search, String priceRange, String eventDuration, String location, String educationalFocus, String learningOutcome);
    public void saveCourse(Course course);
}
