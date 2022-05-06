package com.learning.apex.apexelearning.payments;

import com.learning.apex.apexelearning.entity.Course;
import com.learning.apex.apexelearning.entity.Student;
import com.learning.apex.apexelearning.exceptions.ResourceNotFoundException;
import com.learning.apex.apexelearning.payload.CourseEnrollmentDto;
import com.learning.apex.apexelearning.repository.CourseRepository;
import com.learning.apex.apexelearning.repository.StudentRepository;
import org.springframework.stereotype.Component;

@Component
public class ProcessPayment {


    private StudentRepository studentRepository;
    private CourseRepository courseRepository;

    public ProcessPayment(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public boolean process(CourseEnrollmentDto courseEnrollmentDto){
        Student student = studentRepository.findById(courseEnrollmentDto.getStudentId()).orElseThrow(() -> new ResourceNotFoundException("Student", "id", courseEnrollmentDto.getStudentId()));
        Course course = courseRepository.getById(courseEnrollmentDto.getCourseId());
        PaymentProcessor paymentProcessor  = PaymentFactory.create(courseEnrollmentDto.getPaymentMethod());
        return paymentProcessor.pay(student,course.getAmount());
    }
}
