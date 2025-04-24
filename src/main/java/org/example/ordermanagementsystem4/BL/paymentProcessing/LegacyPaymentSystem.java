package org.example.ordermanagementsystem4.BL.paymentProcessing;

import org.springframework.stereotype.Component;

@Component
public class LegacyPaymentSystem {
    public void makePayment(String amount) {
        System.out.println("Legacy payment processed for amount: " + amount);
    }


}
