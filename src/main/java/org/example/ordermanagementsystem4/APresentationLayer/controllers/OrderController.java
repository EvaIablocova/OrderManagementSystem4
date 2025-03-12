package org.example.ordermanagementsystem2.APresentationLayer.controllers;

import org.example.ordermanagementsystem2.APresentationLayer.DTOs.OrderDTO;
import org.example.ordermanagementsystem2.Db.models.OrderBuilder;
import org.example.ordermanagementsystem2.APresentationLayer.DTOs.UserDTO;
import org.example.ordermanagementsystem2.BL.services.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String getAllOrders(Model model) {
        List<OrderDTO> orderDTOS = orderService.getAllOrders();
        model.addAttribute("orders", orderDTOS);
        return "orders";
    }

    @PostMapping("/create")
    public String createOrder(@RequestBody OrderDTO orderDTO) {
        orderService.createOrder(orderDTO);
        return "redirect:/orders";
    }

    @PostMapping("/clone/{id}")
    public String cloneOrder(@PathVariable Long id) {
        orderService.cloneOrder(id);
        return "redirect:/orders";
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable(name="id") Long id, @RequestBody OrderDTO orderDTO) {
        orderService.update(id, orderDTO);
        return "redirect:/orders";
    }

    @PostMapping ("/delete/{id}")
    public String deleteById(@PathVariable(name="id") Long Id, RedirectAttributes redirectAttributes) {
        orderService.deleteById(Id);
        return "redirect:/orders";
    }






}
