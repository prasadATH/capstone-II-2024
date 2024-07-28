package com.joelcodes.studentsystem.service;

import com.joelcodes.studentsystem.model.Course;
import com.joelcodes.studentsystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getFilteredCourses(String search, String priceRange, String eventDuration, String location, String educationalFocus, String learningOutcome) {
        // Implement the filtering logic here
        return courseRepository.findAll().stream()
                .filter(course -> (search == null || course.getName().toLowerCase().contains(search.toLowerCase())))
                .filter(course -> (priceRange == null || course.getPrice().toLowerCase().contains(priceRange.toLowerCase())))
                .filter(course -> (eventDuration == null || course.getStandard().toLowerCase().contains(eventDuration.toLowerCase())))
                .filter(course -> (location == null || course.getLocation().toLowerCase().contains(location.toLowerCase())))
                .filter(course -> (educationalFocus == null || course.getStandard().toLowerCase().contains(educationalFocus.toLowerCase())))
                .filter(course -> (learningOutcome == null || course.getStandard().toLowerCase().contains(learningOutcome.toLowerCase())))
                .toList();
    }

    @Override
    public void saveCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void deleteCourseById(int id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Course getCourseById(int id) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        return optionalCourse.orElse(null);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
