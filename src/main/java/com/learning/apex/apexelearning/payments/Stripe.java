package com.learning.apex.apexelearning.payments;

import com.learning.apex.apexelearning.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


// low level modules
@Component
public class Stripe {

    private Logger logger = LoggerFactory.getLogger(PayPal.class);



    boolean makePayment(Student student, double amount){
        logger.info(student.getFirstName()+ " made payment of "+ amount+ " with Stripe");
        return true;
    }
}
