package org.example.ordermanagementsystem4.Db.models;

import jakarta.persistence.*;
import lombok.Data;
import org.example.ordermanagementsystem4.APresentationLayer.DTOs.OrderDTO;

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
    private String status;

    public Order() {}

    public Order(String customerName, String shippingAddress, List<String> items,
                 double totalAmount, String paymentMethod, String deliveryMethod, String status) {
        this.username = customerName;
        this.shippingAddress = shippingAddress;
        this.items = items;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.deliveryMethod = deliveryMethod;
        this.status = status;
    }

    public Order(OrderDTO orderDTO) {
        this.username = orderDTO.getUsername();
        this.shippingAddress = orderDTO.getShippingAddress();
        this.items = orderDTO.getItems();
        this.totalAmount = orderDTO.getTotalAmount();
        this.paymentMethod = orderDTO.getPaymentMethod();
        this.deliveryMethod = orderDTO.getDeliveryMethod();
        this.status = orderDTO.getStatus();
    }

    public Order clone() {
        return new Order(username, shippingAddress, List.copyOf(items), totalAmount, paymentMethod, deliveryMethod, status);
    }

}