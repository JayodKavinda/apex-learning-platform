package com.learning.apex.apexelearning.repository;

import com.learning.apex.apexelearning.entity.Instructor;
import com.learning.apex.apexelearning.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByEmail(String email);
    Optional<Student> findByUserNameOrEmail(String username, String email);
    Optional<Student> findByUserName(String userName);
    Boolean existsByUserName(String userName);
    Boolean existsByEmail(String email);
}
