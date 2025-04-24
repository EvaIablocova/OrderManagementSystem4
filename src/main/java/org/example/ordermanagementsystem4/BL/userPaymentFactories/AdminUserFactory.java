package org.example.ordermanagementsystem4.BL.userPaymentFactories;

import org.example.ordermanagementsystem4.BL.interfaces.PaymentMethodInterface;
import org.example.ordermanagementsystem4.BL.interfaces.UserInterface;
import org.example.ordermanagementsystem4.BL.interfaces.UserPaymentFactory;
import org.example.ordermanagementsystem4.BL.users.AdminUser;
import org.example.ordermanagementsystem4.Db.paymentMethods.BankTransferPayment;

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