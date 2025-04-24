package org.example.ordermanagementsystem4.BL.services;

import org.example.ordermanagementsystem4.APresentationLayer.DTOs.OrderDTO;
import org.example.ordermanagementsystem4.Db.models.Order;
import org.example.ordermanagementsystem4.Db.models.OrderBuilder;
import org.example.ordermanagementsystem4.Db.repositories.OrderRepository;
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
                .setStatus(orderDTO.getStatus())
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


    public OrderDTO processById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        OrderDTO entity = new OrderDTO(order);
        entity.setStatus("Processed");
        return update (id, entity);
    }



}
