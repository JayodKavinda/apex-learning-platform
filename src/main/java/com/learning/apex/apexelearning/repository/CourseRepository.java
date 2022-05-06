package com.learning.apex.apexelearning.repository;

import com.learning.apex.apexelearning.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
