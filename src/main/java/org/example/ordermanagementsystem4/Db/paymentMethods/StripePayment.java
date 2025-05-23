package org.example.ordermanagementsystem4.Db.paymentMethods;

import org.example.ordermanagementsystem4.BL.interfaces.PaymentMethodInterface;

public class StripePayment implements PaymentMethodInterface {

    @Override
    public String getPaymentMethodId() {
        return "Stripe Payment";
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Stripe payment of $" + amount);
    }
}