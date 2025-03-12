package org.example.ordermanagementsystem2.BL.userPaymentFactories;

import org.example.ordermanagementsystem2.BL.interfaces.PaymentMethodInterface;
import org.example.ordermanagementsystem2.BL.interfaces.UserInterface;
import org.example.ordermanagementsystem2.BL.interfaces.UserPaymentFactory;
import org.example.ordermanagementsystem2.Db.paymentMethods.StripePayment;
import org.example.ordermanagementsystem2.BL.users.GuestUser;

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

