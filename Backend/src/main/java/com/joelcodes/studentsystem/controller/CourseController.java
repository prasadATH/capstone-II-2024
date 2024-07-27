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
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin

public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/filter")
    public List<CourseDto> getFilteredCourses(@RequestBody FilterCriteria filterCriteria) {
        List<Course> courses = courseService.getFilteredCourses(
                filterCriteria.getSearch(),
                filterCriteria.getPriceRange(),
                filterCriteria.getEventDuration(),
                filterCriteria.getLocation(),
                filterCriteria.getEducationalFocus(),
                filterCriteria.getLearningOutcome()
        );

        return courses.stream().map(course -> {
            CourseDto dto = new CourseDto();
            dto.setTitle(course.getName());  // Adjust according to your Course model
            dto.setPrice(course.getPrice()); // Adjust according to your Course model
            dto.setStandard(course.getStandard()); // Adjust according to your Course model
            dto.setLocation(course.getLocation()); // Adjust according to your Course model

            try {
                if (course.getImage() != null) {
                    dto.setImage(convertBlobToBase64(course.getImage()));
                }
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }

            return dto;
        }).collect(Collectors.toList());
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

    private String convertBlobToBase64(Blob blob) throws IOException, SQLException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(blob.getBytes(1, (int) blob.length()));
        byte[] bytes = inputStream.readAllBytes();
        return Base64.getEncoder().encodeToString(bytes);
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

    public class CourseDto {
        private String title;
        private String price;
        private String standard;
        private String location;
        private String image;

        // Getters and Setters
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
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

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }


}

