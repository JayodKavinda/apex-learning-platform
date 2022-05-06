package com.learning.apex.apexelearning.service;

import com.learning.apex.apexelearning.entity.Student;
import com.learning.apex.apexelearning.payload.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    StudentDto saveStudent(StudentDto studentDto);
    List<StudentDto> getAllStudents();
    StudentDto updateStudent(StudentDto studentDto, long id);
    StudentDto getStudentById(long id);
    void deleteStudent(long id);
}
