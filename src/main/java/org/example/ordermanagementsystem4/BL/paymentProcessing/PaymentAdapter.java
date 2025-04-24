package org.example.ordermanagementsystem4.BL.paymentProcessing;

import org.example.ordermanagementsystem4.BL.interfaces.PaymentProcessor;
import org.springframework.stereotype.Component;

@Component
public class PaymentAdapter implements PaymentProcessor {
    private LegacyPaymentSystem legacySystem;

    public PaymentAdapter(LegacyPaymentSystem legacySystem) {
        this.legacySystem = legacySystem;
    }

    @Override
    public boolean processPayment(double amount) {
        try {
            legacySystem.makePayment(String.valueOf(amount));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
