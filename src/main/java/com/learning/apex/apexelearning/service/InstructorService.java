package com.learning.apex.apexelearning.service;

import com.learning.apex.apexelearning.payload.InstructorDto;

import java.util.List;

public interface InstructorService {

    InstructorDto createInstructor (InstructorDto instructorDto);
    List<InstructorDto> getAllInstructors();
    InstructorDto getInstructorById(long id);
    InstructorDto updateInstructor(InstructorDto instructorDto, long id);
    void deleteInstructorById(long id);
}
