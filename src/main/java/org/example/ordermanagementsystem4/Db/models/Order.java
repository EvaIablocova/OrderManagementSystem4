package org.example.ordermanagementsystem2.Db.models;

import jakarta.persistence.*;
import lombok.*;
import org.example.ordermanagementsystem2.APresentationLayer.DTOs.OrderDTO;

import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String shippingAddress;

    @ElementCollection
    private List<String> items;

    private double totalAmount;
    private String paymentMethod;
    private String deliveryMethod;

    public Order() {}

    public Order(String customerName, String shippingAddress, List<String> items,
                 double totalAmount, String paymentMethod, String deliveryMethod) {
        this.username = customerName;
        this.shippingAddress = shippingAddress;
        this.items = items;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.deliveryMethod = deliveryMethod;
    }

    public Order(OrderDTO orderDTO) {
        this.username = orderDTO.getUsername();
        this.shippingAddress = orderDTO.getShippingAddress();
        this.items = orderDTO.getItems();
        this.totalAmount = orderDTO.getTotalAmount();
        this.paymentMethod = orderDTO.getPaymentMethod();
        this.deliveryMethod = orderDTO.getDeliveryMethod();
    }

    public Order clone() {
        return new Order(username, shippingAddress, List.copyOf(items), totalAmount, paymentMethod, deliveryMethod);
    }

}