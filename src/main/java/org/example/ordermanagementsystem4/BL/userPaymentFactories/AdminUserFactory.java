package org.example.ordermanagementsystem2.BL.userPaymentFactories;

import org.example.ordermanagementsystem2.BL.interfaces.PaymentMethodInterface;
import org.example.ordermanagementsystem2.BL.interfaces.UserInterface;
import org.example.ordermanagementsystem2.BL.interfaces.UserPaymentFactory;
import org.example.ordermanagementsystem2.Db.paymentMethods.BankTransferPayment;
import org.example.ordermanagementsystem2.BL.users.AdminUser;

public class AdminUserFactory implements UserPaymentFactory {
    @Override
    public UserInterface createUser() {
        return new AdminUser();
    }

    @Override
    public PaymentMethodInterface createPaymentMethod() {
        return new BankTransferPayment();
    }
}