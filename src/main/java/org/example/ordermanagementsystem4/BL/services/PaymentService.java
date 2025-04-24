package org.example.ordermanagementsystem4.BL.services;

import org.example.ordermanagementsystem4.BL.interfaces.PaymentProcessor;
import org.example.ordermanagementsystem4.Db.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final PaymentProcessor paymentProcessor;

    @Autowired
    public PaymentService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public boolean executePayment(Order order) {
        return paymentProcessor.processPayment(order.getTotalAmount());
    }
}