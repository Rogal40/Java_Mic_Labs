package org.example.orderservice.service;

import org.example.orderservice.entity.Order;
import org.example.orderservice.feign.UserClient;
import org.example.orderservice.model.User;
import org.example.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserClient userClient;

    public OrderService(OrderRepository orderRepository, UserClient userClient) {
        this.orderRepository = orderRepository;
        this.userClient = userClient;
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order create(Order order) {
        User user = userClient.getUserById(order.getUserId());
        if (user == null) throw new RuntimeException("User not found");

        return orderRepository.save(order);
    }
}
