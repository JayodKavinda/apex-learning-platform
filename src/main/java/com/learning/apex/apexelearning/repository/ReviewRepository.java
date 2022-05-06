package com.learning.apex.apexelearning.repository;

import com.learning.apex.apexelearning.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
