package com.learning.apex.apexelearning.controller;

import com.learning.apex.apexelearning.payload.InstructorDto;
import com.learning.apex.apexelearning.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
/**
@RestController
public class InstructorController {
    private InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping("api/instructor")
    public ResponseEntity<InstructorDto> createInstructor(@Valid @RequestBody InstructorDto instructorDto){
        return new ResponseEntity<>(instructorService.createInstructor(instructorDto), HttpStatus.CREATED);
    }

    @GetMapping("api/instructor/{id}")
    public ResponseEntity<InstructorDto> getInstructorById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(instructorService.getInstructorById(id));
    }

    @PutMapping("api/instructor/{id}")
    public ResponseEntity<InstructorDto> updateInstructor(@Valid @RequestBody InstructorDto instructorDto, @PathVariable(name = "id") long id){
        InstructorDto instructorDto1 = instructorService.updateInstructor(instructorDto,id);
        return new ResponseEntity<>(instructorDto1, HttpStatus.CREATED);
    }

    @DeleteMapping("api/instructor/{id}")
    public ResponseEntity<String> deleteInstructor(@PathVariable(name = "id") long id){
        instructorService.deleteInstructorById(id);
        return new ResponseEntity<>("Instructor deleted successfully.", HttpStatus.OK);
    }
}

 **/