package com.learning.apex.apexelearning.payload;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class RoleDto {
    private long id;
    @NotEmpty
    private String roleName;
}
