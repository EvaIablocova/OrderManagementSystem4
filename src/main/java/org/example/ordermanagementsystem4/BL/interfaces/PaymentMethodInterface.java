package org.example.ordermanagementsystem4.BL.interfaces;

public interface PaymentMethodInterface {
    String getPaymentMethodId();
    void processPayment(double amount);
}
