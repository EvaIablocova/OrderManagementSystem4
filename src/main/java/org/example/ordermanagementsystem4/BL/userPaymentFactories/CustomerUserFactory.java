package org.example.ordermanagementsystem2.BL.userPaymentFactories;

import org.example.ordermanagementsystem2.BL.interfaces.PaymentMethodInterface;
import org.example.ordermanagementsystem2.BL.interfaces.UserInterface;
import org.example.ordermanagementsystem2.BL.interfaces.UserPaymentFactory;
import org.example.ordermanagementsystem2.Db.paymentMethods.PayPalPayment;
import org.example.ordermanagementsystem2.BL.users.CustomerUser;

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
