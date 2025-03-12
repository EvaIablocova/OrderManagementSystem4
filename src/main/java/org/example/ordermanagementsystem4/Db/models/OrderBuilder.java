package org.example.ordermanagementsystem2.Db.models;

import org.example.ordermanagementsystem2.APresentationLayer.DTOs.OrderDTO;

import java.util.ArrayList;
import java.util.List;

public class OrderBuilder {
    private String customerName;
    private String shippingAddress;
    private List<String> items = new ArrayList<>();
    private double totalAmount;
    private String paymentMethod;
    private String deliveryMethod;

    // Устанавливаем имя клиента
    public OrderBuilder setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;  // Возвращаем текущий объект для продолжения цепочки
    }

    // Устанавливаем адрес доставки
    public OrderBuilder setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
        return this;
    }

    // Добавляем товар в заказ
    public OrderBuilder addItem(String item) {
        this.items.add(item);
        return this;
    }

    // Устанавливаем общую сумму заказа
    public OrderBuilder setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    // Устанавливаем метод оплаты
    public OrderBuilder setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    // Устанавливаем метод доставки
    public OrderBuilder setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
        return this;
    }

    public OrderBuilder setItems(List<String> items) {
        this.items = items;
        return this;
    }

    // Строим объект заказа
    public Order build() {
        return new Order(customerName, shippingAddress, items, totalAmount, paymentMethod, deliveryMethod);
    }
}
