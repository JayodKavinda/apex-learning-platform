package com.learning.apex.apexelearning.payload;

import com.learning.apex.apexelearning.entity.Course;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class StudentDto {

    private Long id;

    @NotEmpty
    @Size(min = 2, message = "First Name should have at least 2 characters")
    private String firstName;
    @NotEmpty
    @Size(min = 2, message = "Last Name should have at least 2 characters")
    private String lastName;
    @Email
    private String email;

    private String userName;

    private String password;
    private List<Course> courses;

}
