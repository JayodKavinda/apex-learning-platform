package com.learning.apex.apexelearning.payments;

import com.learning.apex.apexelearning.entity.Course;
import com.learning.apex.apexelearning.entity.Student;
import com.learning.apex.apexelearning.payload.CourseEnrollmentDto;
import com.learning.apex.apexelearning.repository.CourseRepository;
import com.learning.apex.apexelearning.repository.StudentRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(MockitoJUnitRunner.class)
public class ProcessPaymentTest {

    @Mock
    StudentRepository studentRepository;
    @Mock
    CourseRepository courseRepository;

    @Mock
    PaymentFactory paymentFactory;

    @Mock
    PaypalPaymentProcessor paymentProcessor;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void paymentProcessTest(){
        CourseEnrollmentDto dto = new CourseEnrollmentDto(1L,1L,"paypal");
        Student student= new Student(1L,"nimal","kamal","nimal@test.com","nimal2","abc123",null,null);
        Course course = new Course(1L,"course1",123,null,null,null);

        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));
        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));

        //PaymentProcessor paymentProcessor  = paymentFactory.create(dto.getPaymentMethod());

        boolean e = paymentProcessor.pay(student,0);
        assertTrue(paymentProcessor.pay(student,200));
    }

}