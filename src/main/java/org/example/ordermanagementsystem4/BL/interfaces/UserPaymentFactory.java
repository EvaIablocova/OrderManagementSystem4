package org.example.ordermanagementsystem2.BL.interfaces;

//import org.example.ordermanagementsystem2.Db.models.User;

//Абстрактная фабрика для пользователей и платежных методов
public interface UserPaymentFactory {
    UserInterface createUser();
    PaymentMethodInterface createPaymentMethod();
}