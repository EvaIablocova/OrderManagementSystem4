package org.example.ordermanagementsystem2.BL.interfaces;

public interface PaymentMethodInterface {
    String getPaymentMethodId();
    void processPayment(double amount);
}
