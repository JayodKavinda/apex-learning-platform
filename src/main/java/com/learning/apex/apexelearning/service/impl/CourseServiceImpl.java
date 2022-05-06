package com.learning.apex.apexelearning.service.impl;

import com.learning.apex.apexelearning.entity.Course;
import com.learning.apex.apexelearning.entity.Instructor;
import com.learning.apex.apexelearning.entity.Student;
import com.learning.apex.apexelearning.exceptions.ResourceNotFoundException;
import com.learning.apex.apexelearning.payload.CourseDto;
import com.learning.apex.apexelearning.payload.CourseEnrollmentDto;
import com.learning.apex.apexelearning.repository.CourseRepository;
import com.learning.apex.apexelearning.repository.InstructorRepository;
import com.learning.apex.apexelearning.repository.StudentRepository;
import com.learning.apex.apexelearning.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private ModelMapper modelMapper;
    private CourseRepository courseRepository;
    private InstructorRepository instructorRepository;
    private StudentRepository studentRepository;

    public CourseServiceImpl(ModelMapper modelMapper, CourseRepository courseRepository, InstructorRepository instructorRepository, StudentRepository studentRepository) {
        this.modelMapper = modelMapper;
        this.courseRepository = courseRepository;
        this.instructorRepository = instructorRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public CourseDto createCourse(CourseDto courseDto) {
        Instructor instructor = instructorRepository.getById(courseDto.getInstructorId());
        Course course = mapToEntity(courseDto);
        course.setInstructor(instructor);
        Course resCourse = courseRepository.save(course);
        return mapToDto(resCourse);
    }

    @Override
    public List<CourseDto> getAllCourses(long instructorId) {
        return null;
    }

    @Override
    public CourseDto getCourseById(long id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course", "id", id));
        return mapToDto(course);
    }

    @Override
    public CourseDto updateCourse(CourseDto courseDto, long id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course", "id", id));
        Instructor instructor = instructorRepository.getById(courseDto.getInstructorId());
        course.setTitle(courseDto.getTitle());
        course.setInstructor(instructor);
        Course updatedCourse = courseRepository.save(course);
        return mapToDto(updatedCourse);
    }

    @Override
    public void deleteCourse(long id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course", "id", id));
        courseRepository.delete(course);
    }

    @Override
    public void enrollStudent(CourseEnrollmentDto courseEnrollmentDto) {
        long courseId = courseEnrollmentDto.getCourseId();
        long studentId = courseEnrollmentDto.getStudentId();
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course", "id", courseId));
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student","id",studentId));
        course.addStudent(student);
        courseRepository.save(course);
    }

    private CourseDto mapToDto(Course newCourse) {
        CourseDto courseDto = modelMapper.map(newCourse, CourseDto.class);
        return courseDto;
    }

    private Course mapToEntity(CourseDto courseDto) {
        Course course = modelMapper.map(courseDto, Course.class);
        return course;
    }
}
