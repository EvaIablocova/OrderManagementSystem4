package org.example.ordermanagementsystem4.APresentationLayer.DTOs;

import lombok.Getter;
import lombok.Setter;
import org.example.ordermanagementsystem4.Db.models.Order;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OrderDTO implements Cloneable {
    private Long id;
    private String username;
    private String shippingAddress;
    private List<String> items;
    private double totalAmount;
    private String paymentMethod;
    private String deliveryMethod;
    private String status;

    public OrderDTO() {}

    public OrderDTO(String customerName, String shippingAddress, List<String> items,
                    double totalAmount, String paymentMethod, String deliveryMethod, String status) {
        this.username = customerName;
        this.shippingAddress = shippingAddress;
        this.items = items;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.deliveryMethod = deliveryMethod;
        this.status = status;
    }

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.username = order.getUsername();
        this.shippingAddress = order.getShippingAddress();
        this.items = new ArrayList<>(order.getItems());
        this.totalAmount = order.getTotalAmount();
        this.paymentMethod = order.getPaymentMethod();
        this.deliveryMethod = order.getDeliveryMethod();
        this.status = order.getStatus();
    }

    // Глубокое клонирование списка товаров
    @Override
    public OrderDTO clone() {
        try {
            OrderDTO clonedOrderDTO = (OrderDTO) super.clone();
            clonedOrderDTO.items = List.copyOf(this.items); // Создаём новую копию списка
            return clonedOrderDTO;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported", e);
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "username='" + username + '\'' +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", items=" + items +
                ", totalAmount=" + totalAmount +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", deliveryMethod='" + deliveryMethod + '\'' +
                ", status='" + status + '\'' +
                '}';
    }


}
