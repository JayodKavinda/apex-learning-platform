package com.learning.apex.apexelearning.payments;

import com.learning.apex.apexelearning.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class PaypalPaymentProcessor  implements  PaymentProcessor{


    private PayPal payPal;

    public PaypalPaymentProcessor( PayPal payPal) {
        this.payPal = payPal;
    }

    @Override
    public boolean pay(Student student, double amount) {
        return payPal.makePayment(student, amount);
    }
}
