package com.learning.apex.apexelearning.controller;

import com.learning.apex.apexelearning.entity.Role;
import com.learning.apex.apexelearning.payload.RoleDto;
import com.learning.apex.apexelearning.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
/**
@RestController
public class RoleController {

    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/createNewRole")
    public ResponseEntity<RoleDto> createRole(@RequestBody RoleDto role){
        return new ResponseEntity<>(roleService.createRole(role), HttpStatus.CREATED);
    }
}

 **/
