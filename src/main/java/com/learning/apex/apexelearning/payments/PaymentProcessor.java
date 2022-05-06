package com.learning.apex.apexelearning.payments;

import com.learning.apex.apexelearning.entity.Student;

/**
 *
 * Use dependency inversion principle for decoupling high level and low level module
 * by introducing abstraction between them (payment processor)
 *
 * **/

public interface PaymentProcessor {

    boolean pay(Student student, double amount);
}
