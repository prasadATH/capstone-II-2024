package com.joelcodes.studentsystem.controller;

import com.joelcodes.studentsystem.model.Course;
import com.joelcodes.studentsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            dto.setTitle(course.getName());
            dto.setPrice(course.getPrice());
            dto.setStandard(course.getStandard());
            dto.setLocation(course.getLocation());
            dto.setImage(course.getImage());
            dto.setEducationalFocus(course.getEducationalFocus());
            dto.setLearningOutcome(course.getLearningOutcome());
            dto.setEventDuration(course.getEventDuration());
            return dto;
        }).collect(Collectors.toList());
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addCourse(@RequestParam("image") String imageUrl, @RequestParam("name") String name,
                                          @RequestParam("price") String price, @RequestParam("standard") String standard,
                                          @RequestParam("location") String location,
                                          @RequestParam("educationalFocus") String educationalFocus,
                                          @RequestParam("learningOutcome") String learningOutcome,
                                          @RequestParam("eventDuration") String eventDuration) {
        String thumbnailImageUrl = convertToThumbnailLink(imageUrl);
        Course course = new Course(thumbnailImageUrl, name, price, standard, location, educationalFocus, learningOutcome, eventDuration);
        courseService.saveCourse(course);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCourseById(@PathVariable int id) {
        courseService.deleteCourseById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable int id) {
        Course course = courseService.getCourseById(id);
        if (course == null) {
            return ResponseEntity.notFound().build();
        }
        CourseDto dto = new CourseDto();
        dto.setTitle(course.getName());
        dto.setPrice(course.getPrice());
        dto.setStandard(course.getStandard());
        dto.setLocation(course.getLocation());
        dto.setImage(course.getImage());
        dto.setEducationalFocus(course.getEducationalFocus());
        dto.setLearningOutcome(course.getLearningOutcome());
        dto.setEventDuration(course.getEventDuration());
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<CourseDto>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        List<CourseDto> courseDtos = courses.stream().map(course -> {
            CourseDto dto = new CourseDto();
            dto.setTitle(course.getName());
            dto.setPrice(course.getPrice());
            dto.setStandard(course.getStandard());
            dto.setLocation(course.getLocation());
            dto.setImage(course.getImage());
            dto.setEducationalFocus(course.getEducationalFocus());
            dto.setLearningOutcome(course.getLearningOutcome());
            dto.setEventDuration(course.getEventDuration());
            return dto;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(courseDtos);
    }

    @PutMapping("/update-image/{id}")
    public ResponseEntity<Void> updateCourseImage(@PathVariable int id, @RequestParam("image") String imageUrl) {
        String thumbnailImageUrl = convertToThumbnailLink(imageUrl);
        courseService.updateCourseImage(id, thumbnailImageUrl);
        return ResponseEntity.ok().build();
    }

    private String convertToThumbnailLink(String link) {
        String fileId = link.split("/d/")[1].split("/")[0];
        return "https://drive.google.com/thumbnail?id=" + fileId;
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
        private String educationalFocus;
        private String learningOutcome;
        private String eventDuration;

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
}
