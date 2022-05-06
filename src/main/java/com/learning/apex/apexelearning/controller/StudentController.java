package com.learning.apex.apexelearning.controller;

import com.learning.apex.apexelearning.payload.StudentDto;
import com.learning.apex.apexelearning.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
@RestController
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("api/student")
    public ResponseEntity<StudentDto> saveStudent(@Valid @RequestBody StudentDto studentDto){
        return new ResponseEntity<>(studentService.saveStudent(studentDto), HttpStatus.CREATED);
    }

    @GetMapping("api/student/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @DeleteMapping("api/student/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable(name = "id") long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>("Student deleted successfully.", HttpStatus.OK);
    }
}

 **/
