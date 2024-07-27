package com.joelcodes.studentsystem.controller;



import com.joelcodes.studentsystem.model.Course;
import com.joelcodes.studentsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
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
    public ResponseEntity<Void> addCourse(@RequestParam("image") MultipartFile image, @RequestParam("name") String name,
                                          @RequestParam("price") String price, @RequestParam("standard") String standard,
                                          @RequestParam("location") String location) {
        try {
            Blob blobImage = new javax.sql.rowset.serial.SerialBlob(image.getBytes());
            Course course = new Course(blobImage, name, price, standard, location);
            courseService.saveCourse(course);
            return ResponseEntity.ok().build();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCourseById(@PathVariable int id) {
        courseService.deleteCourseById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getCourseById(@PathVariable int id) {
        Course course = courseService.getCourseById(id);
        if (course == null) {
            return ResponseEntity.notFound().build();
        }
        try {
            byte[] imageBytes = course.getImage().getBytes(1, (int) course.getImage().length());
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG); // or MediaType.IMAGE_PNG based on your image type
            headers.setContentLength(imageBytes.length);
            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
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

