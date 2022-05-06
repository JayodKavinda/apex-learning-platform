package com.learning.apex.apexelearning.service;

import com.learning.apex.apexelearning.entity.Course;
import com.learning.apex.apexelearning.payload.CourseDto;
import com.learning.apex.apexelearning.payload.CourseEnrollmentDto;

import java.util.List;

public interface CourseService {

    CourseDto createCourse(CourseDto courseDto);
    List<CourseDto> getAllCourses(long instructorId);
    CourseDto getCourseById(long id);
    CourseDto updateCourse(CourseDto courseDto, long id);
    void deleteCourse(long id);
    void enrollStudent(CourseEnrollmentDto courseEnrollmentDto);
}
