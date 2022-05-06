package com.learning.apex.apexelearning.service.impl;

import com.learning.apex.apexelearning.entity.Role;
import com.learning.apex.apexelearning.entity.Student;
import com.learning.apex.apexelearning.payload.RoleDto;
import com.learning.apex.apexelearning.payload.StudentDto;
import com.learning.apex.apexelearning.repository.RoleRepository;
import com.learning.apex.apexelearning.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository repository;
    private ModelMapper mapper;

    public RoleServiceImpl(RoleRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public RoleDto createRole(RoleDto roleDto) {
        Role role = mapToEntity(roleDto);
        Role role1 = repository.save(role);
        RoleDto roleDto1 = mapToDto(role1);

        return roleDto1;
    }

    private RoleDto mapToDto(Role newRole) {
        RoleDto roleDto = mapper.map(newRole, RoleDto.class);
        return roleDto;
    }

    private Role mapToEntity(RoleDto roleDto) {
        Role role = mapper.map(roleDto, Role.class);
        return role;
    }
}
