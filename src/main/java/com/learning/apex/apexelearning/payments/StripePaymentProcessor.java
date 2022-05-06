package com.learning.apex.apexelearning.payments;


import com.learning.apex.apexelearning.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StripePaymentProcessor implements PaymentProcessor{
    private Stripe stripe;

    public StripePaymentProcessor(Stripe stripe) {
        this.stripe = stripe;
    }


    @Override
    public boolean pay(Student student, double amount) {
        return stripe.makePayment(student,amount);
    }
}
