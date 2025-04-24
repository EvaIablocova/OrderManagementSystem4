package org.example.ordermanagementsystem4.BL.userPaymentFactories;

import org.example.ordermanagementsystem4.BL.interfaces.PaymentMethodInterface;
import org.example.ordermanagementsystem4.BL.interfaces.UserInterface;
import org.example.ordermanagementsystem4.BL.interfaces.UserPaymentFactory;
import org.example.ordermanagementsystem4.BL.users.CustomerUser;
import org.example.ordermanagementsystem4.Db.paymentMethods.PayPalPayment;

public class CustomerUserFactory implements UserPaymentFactory {
    @Override
    public UserInterface createUser() {
        return new CustomerUser();
    }

    @Override
    public PaymentMethodInterface createPaymentMethod() {
        return new PayPalPayment();
    }
}
