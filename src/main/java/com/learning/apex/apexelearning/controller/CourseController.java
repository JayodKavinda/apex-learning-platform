package com.learning.apex.apexelearning.controller;


import com.learning.apex.apexelearning.payload.CourseDto;
import com.learning.apex.apexelearning.payload.CourseEnrollmentDto;
import com.learning.apex.apexelearning.repository.InstructorRepository;
import com.learning.apex.apexelearning.service.CourseService;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;


    @Operation(summary = "Create Course REST API")
    @PostMapping("/api/course")
    @PreAuthorize("hasRole('ROLE_INSTRUCTOR')")
    public ResponseEntity<CourseDto> createCourse(@Valid @RequestBody CourseDto courseDto){

        return new ResponseEntity<>(courseService.createCourse(courseDto), HttpStatus.CREATED);
    }

    @Operation(summary = "Get Course by Id REST API")
    @GetMapping("api/course/{id}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @Operation(summary = "Enroll Course by Student REST API")
    @PostMapping("api/course/buy")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public ResponseEntity<String> buyCourse(@Valid @RequestBody CourseEnrollmentDto courseEnrollmentDto){
        courseService.enrollStudent(courseEnrollmentDto);
        return new ResponseEntity<>("Payment Success and Successfully Enrolled", HttpStatus.OK);
    }
}
