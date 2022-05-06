package com.learning.apex.apexelearning.payload;

import com.learning.apex.apexelearning.entity.Course;
import com.learning.apex.apexelearning.entity.InstructorDetails;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class InstructorDto {

    private Long id;
    @NotEmpty
    @Size(min = 2, message = "First Name should have at least 2 characters")
    private String firstName;
    @NotEmpty
    @Size(min = 3, message = "Username should have at least 3 characters")
    private String username;
    @NotEmpty
    @Size(min = 2, message = "Last name should have at least 2 characters")
    private String lastName;
    @NotEmpty
    @Email(message = "Email should valid")
    private String email;

    private InstructorDetails instructorDetails;

    private List<Course> courses;
}
