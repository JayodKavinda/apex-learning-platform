package com.learning.apex.apexelearning.repository;

import com.learning.apex.apexelearning.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface InstructorRepository extends JpaRepository<Instructor,Long> {
    Optional<Instructor> findByEmail(String email);
    Optional<Instructor> findByUserNameOrEmail(String username, String email);
    Optional<Instructor> findByUserName(String userName);
    Boolean existsByUserName(String userName);
    Boolean existsByEmail(String email);

}
