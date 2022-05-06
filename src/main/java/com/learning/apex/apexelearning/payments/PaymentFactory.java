package com.learning.apex.apexelearning.payments;

import org.springframework.stereotype.Component;

@Component
public class PaymentFactory {

    private static PayPal payPal;
    private static Stripe stripe;

    public PaymentFactory(PayPal payPal, Stripe stripe) {
        this.payPal = payPal;
        this.stripe = stripe;
    }

    public static PaymentProcessor create(String method){
        PaymentProcessor paymentProcessor = null;
        if("paypal".equals(method)){
            paymentProcessor = new PaypalPaymentProcessor(payPal);
        }else{
            paymentProcessor = new StripePaymentProcessor(stripe);
        }

        return paymentProcessor;
    }
}
