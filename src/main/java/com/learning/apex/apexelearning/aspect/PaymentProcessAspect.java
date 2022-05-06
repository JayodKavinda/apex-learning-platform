package com.learning.apex.apexelearning.aspect;


import com.learning.apex.apexelearning.payload.CourseEnrollmentDto;
import com.learning.apex.apexelearning.payments.PayPal;
import com.learning.apex.apexelearning.payments.PaypalPaymentProcessor;
import com.learning.apex.apexelearning.payments.ProcessPayment;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PaymentProcessAspect {

    @Autowired
    private ProcessPayment processPayment;

    private Logger logger = LoggerFactory.getLogger(PayPal.class);

    @Before(value = "execution(* enrollStudent(..))")
    public void beforeEnrollCourse(JoinPoint joinPoint){
        logger.info("Payment Processing..");
        Object[] signatureArgs = joinPoint.getArgs();
        CourseEnrollmentDto courseEnrollmentDto = (CourseEnrollmentDto) signatureArgs[0];

        processPayment.process(courseEnrollmentDto);

        logger.info("Payment Success..");


    }
}
