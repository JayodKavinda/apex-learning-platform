package com.learning.apex.apexelearning.service.impl;

import com.learning.apex.apexelearning.entity.Instructor;
import com.learning.apex.apexelearning.entity.Role;
import com.learning.apex.apexelearning.exceptions.ResourceNotFoundException;
import com.learning.apex.apexelearning.payload.InstructorDto;
import com.learning.apex.apexelearning.repository.InstructorRepository;
import com.learning.apex.apexelearning.repository.RoleRepository;
import com.learning.apex.apexelearning.service.InstructorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl  implements InstructorService {

    private InstructorRepository instructorRepository;
    private RoleRepository roleRepository;
    private ModelMapper modelMapper;

    public InstructorServiceImpl(InstructorRepository instructorRepository, RoleRepository roleRepository, ModelMapper modelMapper) {
        this.instructorRepository = instructorRepository;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public InstructorDto createInstructor(InstructorDto instructorDto) {
        Instructor instructor = mapToEntity(instructorDto);
        Role role = roleRepository.getById(3L); //FIXME id
        instructor.setRole(role);
        Instructor newInstructor = instructorRepository.save(instructor);
        InstructorDto instructorResponse = mapToDto(newInstructor);
        return instructorResponse;
    }

    @Override
    public List<InstructorDto> getAllInstructors() {
        return null;
    }

    @Override
    public InstructorDto getInstructorById(long id) {
        Instructor instructor = instructorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Instructor", "id", id));
        return mapToDto(instructor);
    }

    @Override
    public InstructorDto updateInstructor(InstructorDto instructorDto, long id) {
        // get instructor by id from the database
        Instructor instructor = instructorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Instructor", "id", id));

        instructor.setFirstName(instructorDto.getFirstName());
        instructor.setLastName(instructorDto.getLastName());
        instructor.setUserName(instructorDto.getUsername());
        instructor.setEmail(instructorDto.getEmail());

        Instructor updatedInstructor = instructorRepository.save(instructor);
        return mapToDto(updatedInstructor);
    }

    @Override
    public void deleteInstructorById(long id) {
        Instructor post = instructorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Instructor", "id", id));
        instructorRepository.delete(post);
    }

    private InstructorDto mapToDto(Instructor newInstructor) {
        InstructorDto instructorDto = modelMapper.map(newInstructor, InstructorDto.class);
        return instructorDto;
    }

    private Instructor mapToEntity(InstructorDto instructorDto) {
        Instructor instructor = modelMapper.map(instructorDto, Instructor.class);
        return instructor;
    }
}
