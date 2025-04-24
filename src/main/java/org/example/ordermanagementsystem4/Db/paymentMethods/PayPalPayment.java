package org.example.ordermanagementsystem4.Db.paymentMethods;

import org.example.ordermanagementsystem4.BL.interfaces.PaymentMethodInterface;

public class PayPalPayment implements PaymentMethodInterface {

    @Override
    public String getPaymentMethodId() {
        return "Pay Pal Payment";
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }
}
