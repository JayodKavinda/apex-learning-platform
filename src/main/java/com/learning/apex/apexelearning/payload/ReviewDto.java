package com.learning.apex.apexelearning.payload;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Data
public class ReviewDto {

    private long id;
    @NotEmpty
    @Size(min = 2, message = "Comment should have at least 2 characters")
    private String comment;

    private Long courseId;

}
