package com.learning.apex.apexelearning.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Data
@Getter
@Setter
@AllArgsConstructor
public class CourseEnrollmentDto {


    private long studentId;
    private long courseId;
    @NotEmpty
    private String paymentMethod;
}
