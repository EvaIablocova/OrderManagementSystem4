package org.example.ordermanagementsystem2.BL.using;

import org.example.ordermanagementsystem2.BL.interfaces.PaymentMethodInterface;
import org.example.ordermanagementsystem2.BL.interfaces.UserInterface;
//import org.example.ordermanagementsystem2.APresentationLayer.DTOs.OrderDTO;
//import org.example.ordermanagementsystem2.APresentationLayer.DTOs.OrderDTOBuilder;
//import org.example.ordermanagementsystem2.BL.services.UserPaymentFactoryProvider;
import org.example.ordermanagementsystem2.BL.interfaces.UserPaymentFactory;
import org.example.ordermanagementsystem2.BL.services.UserPaymentFactoryProvider;

public class Using {

    //AbstractFactory
    public static void usingAbstractFactory(String[] args) {
        UserPaymentFactory factory = UserPaymentFactoryProvider.getFactory("customer");

        UserInterface user = factory.createUser();
        PaymentMethodInterface payment = factory.createPaymentMethod();

        System.out.println("User type: " + user.getUserType());
        payment.processPayment(100.0);
    }
//
//
//    //OrderBuilder
//    public static void usingOrderBuilder (String[] args) {
//        OrderDTO orderDTO = new OrderDTOBuilder()
//                .setCustomerName("John Doe")
//                .setShippingAddress("123 Elm Street")
//                .addItem("Laptop")
//                .addItem("Mouse")
//                .setTotalAmount(1200.50)
//                .setPaymentMethod("Credit Card")
//                .setDeliveryMethod("Express")
//                .build();
//
//        System.out.println(orderDTO);
//    }
//

//
//    //Prototype
//    public static void usingPrototype (String[] args) {
//        // Создаём оригинальный заказ
//        OrderDTO originalOrderDTO = new OrderDTO(
//                "John Doe",
//                "123 Elm Street",
//                Arrays.asList("Laptop", "Mouse"),
//                1200.50,
//                "Credit Card",
//                "Express"
//        );
//
//        // Клонируем заказ и меняем адрес доставки
//        OrderDTO clonedOrderDTO = originalOrderDTO.clone();
//        clonedOrderDTO.setShippingAddress("456 Oak Avenue");
//
//        // Выводим оба заказа
//        System.out.println("Original Order: " + originalOrderDTO);
//        System.out.println("Cloned Order: " + clonedOrderDTO);
//    }
}

