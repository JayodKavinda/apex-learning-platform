package com.learning.apex.apexelearning.service.impl;

import com.learning.apex.apexelearning.entity.Course;
import com.learning.apex.apexelearning.entity.Review;
import com.learning.apex.apexelearning.payload.ReviewDto;
import com.learning.apex.apexelearning.repository.CourseRepository;
import com.learning.apex.apexelearning.repository.ReviewRepository;
import com.learning.apex.apexelearning.service.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository repository;
    private ModelMapper modelMapper;
    private CourseRepository courseRepository;

    public ReviewServiceImpl(ReviewRepository repository, ModelMapper modelMapper, CourseRepository courseRepository) {
        this.repository = repository;
        this.modelMapper = modelMapper;
        this.courseRepository = courseRepository;
    }

    @Override
    public ReviewDto postReview(ReviewDto reviewDto) {
        Course course = courseRepository.getById(reviewDto.getCourseId());
        Review newReview = mapToEntity(reviewDto);
        course.addReview(newReview);
        Course resCourse = courseRepository.save(course);
        return reviewDto;
    }

    @Override
    public ReviewDto updateReview(ReviewDto reviewDto) {
        return null;
    }

    @Override
    public void deleteReview(long id) {

    }

    @Override
    public List<ReviewDto> getAllReview(long courseId) {
        return null;
    }

    private ReviewDto mapToDto(Review newReview) {
        ReviewDto reviewDto = modelMapper.map(newReview, ReviewDto.class);
        return reviewDto;
    }

    private Review mapToEntity(ReviewDto reviewDto) {
        Review review = modelMapper.map(reviewDto, Review.class);
        return review;
    }
}
