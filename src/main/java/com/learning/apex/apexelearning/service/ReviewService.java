package com.learning.apex.apexelearning.service;

import com.learning.apex.apexelearning.entity.Review;
import com.learning.apex.apexelearning.payload.ReviewDto;

import java.util.List;

public interface ReviewService {

    ReviewDto postReview(ReviewDto reviewDto);
    ReviewDto updateReview(ReviewDto reviewDto);
    void deleteReview(long id);
    List<ReviewDto> getAllReview(long courseId);
}
