package org.example.ordermanagementsystem4.BL.userPaymentFactories;

import org.example.ordermanagementsystem4.BL.interfaces.PaymentMethodInterface;
import org.example.ordermanagementsystem4.BL.interfaces.UserInterface;
import org.example.ordermanagementsystem4.BL.interfaces.UserPaymentFactory;
import org.example.ordermanagementsystem4.BL.users.GuestUser;
import org.example.ordermanagementsystem4.Db.paymentMethods.StripePayment;

public class GuestUserFactory implements UserPaymentFactory {
    @Override
    public UserInterface createUser() {
        return new GuestUser();
    }

    @Override
    public PaymentMethodInterface createPaymentMethod() {
        return new StripePayment();
    }
}

