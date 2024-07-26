package com.joelcodes.studentsystem.controller;



import com.joelcodes.studentsystem.model.Course;
import com.joelcodes.studentsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin

public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/filter")
    public List<Course> getFilteredCourses(@RequestBody FilterCriteria filterCriteria) {
        return courseService.getFilteredCourses(
                filterCriteria.getSearch(),
                filterCriteria.getPriceRange(),
                filterCriteria.getEventDuration(),
                filterCriteria.getLocation(),
                filterCriteria.getEducationalFocus(),
                filterCriteria.getLearningOutcome()
        );
    }

    @PostMapping("/add")
    public void addCourse(@RequestBody Course course) {
        courseService.saveCourse(course);
    }



    static class FilterCriteria {
        private String search;
        private String priceRange;
        private String eventDuration;
        private String location;
        private String educationalFocus;
        private String learningOutcome;

        // Getters and Setters
        public String getSearch() {
            return search;
        }

        public void setSearch(String search) {
            this.search = search;
        }

        public String getPriceRange() {
            return priceRange;
        }

        public void setPriceRange(String priceRange) {
            this.priceRange = priceRange;
        }

        public String getEventDuration() {
            return eventDuration;
        }

        public void setEventDuration(String eventDuration) {
            this.eventDuration = eventDuration;
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
    }

}

