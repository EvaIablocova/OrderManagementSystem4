package org.example.ordermanagementsystem4.BL.services;

import org.example.ordermanagementsystem4.BL.interfaces.UserPaymentFactory;
import org.example.ordermanagementsystem4.BL.userPaymentFactories.AdminUserFactory;
import org.example.ordermanagementsystem4.BL.userPaymentFactories.CustomerUserFactory;
import org.example.ordermanagementsystem4.BL.userPaymentFactories.GuestUserFactory;

public class UserPaymentFactoryProvider {

    public static UserPaymentFactory getFactory(String userType) {
        switch (userType.toLowerCase()) {
            case "admin":
                return new AdminUserFactory();
            case "customer":
                return new CustomerUserFactory();
            case "guest":
                return new GuestUserFactory();
            default:
                throw new IllegalArgumentException("Unknown user type");
        }
    }
}
