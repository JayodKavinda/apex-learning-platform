package com.learning.apex.apexelearning.controller;

import com.learning.apex.apexelearning.payload.ReviewDto;
import com.learning.apex.apexelearning.service.ReviewService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@Tag(name = "Reviews")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @Operation(summary = "Create Review by Student")
    @PostMapping("api/review")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public ResponseEntity<ReviewDto> postReview(@Valid @RequestBody ReviewDto reviewDto){
        return new ResponseEntity<>(reviewService.postReview(reviewDto), HttpStatus.CREATED);
    }
}
