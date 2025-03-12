package org.example.ordermanagementsystem2.BL.services;

import org.example.ordermanagementsystem2.APresentationLayer.DTOs.UserDTO;
import org.example.ordermanagementsystem2.Db.models.Order;
import org.example.ordermanagementsystem2.APresentationLayer.DTOs.OrderDTO;
import org.example.ordermanagementsystem2.Db.models.OrderBuilder;
import org.example.ordermanagementsystem2.Db.models.User;
import org.example.ordermanagementsystem2.Db.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        List<OrderDTO> orderDTOs = new ArrayList<>();
        for (Order order : orders) {
            orderDTOs.add(new OrderDTO(order));
        }
        return orderDTOs;
    }

    public OrderDTO createOrder(OrderDTO orderDTO) {

        // Используем Builder для создания нового объекта
        Order newOrder = new OrderBuilder()
                .setCustomerName(orderDTO.getUsername())
                .setShippingAddress(orderDTO.getShippingAddress())
                .setItems(orderDTO.getItems())
                .setTotalAmount(orderDTO.getTotalAmount())
                .setPaymentMethod(orderDTO.getPaymentMethod())
                .setDeliveryMethod(orderDTO.getDeliveryMethod())
                .build();


        return new OrderDTO(orderRepository.save(newOrder));
    }

    public OrderDTO cloneOrder(Long orderId) {
        Order original = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        OrderDTO originalDTO = new OrderDTO(original);
        OrderDTO clonedOrderDTO = originalDTO.clone();
        return new OrderDTO(orderRepository.save(new Order(clonedOrderDTO)));
    }

    public OrderDTO update(Long id, OrderDTO entity) {
        Order updatedOrder = new Order(entity);
        updatedOrder.setId(id);
        return new OrderDTO(orderRepository.save(updatedOrder));
    }

    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }



}
