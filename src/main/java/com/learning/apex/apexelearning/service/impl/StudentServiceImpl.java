package com.learning.apex.apexelearning.service.impl;

import com.learning.apex.apexelearning.entity.Course;
import com.learning.apex.apexelearning.entity.Instructor;
import com.learning.apex.apexelearning.entity.Student;
import com.learning.apex.apexelearning.exceptions.ResourceNotFoundException;
import com.learning.apex.apexelearning.payload.CourseDto;
import com.learning.apex.apexelearning.payload.StudentDto;
import com.learning.apex.apexelearning.repository.StudentRepository;
import com.learning.apex.apexelearning.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private ModelMapper mapper;

    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper mapper) {
        this.studentRepository = studentRepository;
        this.mapper = mapper;
    }

    @Override
    public StudentDto saveStudent(StudentDto studentDto) {
        Student student = mapToEntity(studentDto);
        Student resStudent = studentRepository.save(student);
        return mapToDto(resStudent);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        return null;
    }

    @Override
    public StudentDto updateStudent(StudentDto studentDto, long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));

        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());


        Student updatedStudent = studentRepository.save(student);
        return mapToDto(updatedStudent);
    }

    @Override
    public StudentDto getStudentById(long id) {
        return mapToDto(studentRepository.getById(id));
    }

    @Override
    public void deleteStudent(long id) {
        Student stu = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
        studentRepository.delete(stu);
    }

    private StudentDto mapToDto(Student newStudent) {
        StudentDto studentDto = mapper.map(newStudent, StudentDto.class);
        return studentDto;
    }

    private Student mapToEntity(StudentDto studentDto) {
        Student student = mapper.map(studentDto, Student.class);
        return student;
    }
}
