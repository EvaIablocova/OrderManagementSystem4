package org.example.ordermanagementsystem4.Db.paymentMethods;

import org.example.ordermanagementsystem4.BL.interfaces.PaymentMethodInterface;

public class BankTransferPayment implements PaymentMethodInterface {
    @Override
    public String getPaymentMethodId() {
        return "Bank Transfer Payment";
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Bank Transfer payment of $" + amount);
    }
}

