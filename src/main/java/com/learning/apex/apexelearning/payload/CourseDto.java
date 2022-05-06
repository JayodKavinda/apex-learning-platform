package com.learning.apex.apexelearning.payload;

import com.learning.apex.apexelearning.entity.Instructor;
import com.learning.apex.apexelearning.entity.Review;
import com.learning.apex.apexelearning.entity.Student;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class CourseDto {

    private Long id;
    @NotEmpty
    @Size(min = 2, message = "Title should have at least 2 characters")
    private String title;

    private Long instructorId;

    private double amount;

    private List<Review> reviews;

    private List<Student> students;
}
