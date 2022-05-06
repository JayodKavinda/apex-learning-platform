package com.learning.apex.apexelearning.payload;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class InstructorSignUpDto {
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String LastName;
    @NotEmpty
    private String username;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
}
