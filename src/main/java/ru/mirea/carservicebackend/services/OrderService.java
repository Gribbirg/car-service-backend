package ru.mirea.carservicebackend.services;

import ru.mirea.carservicebackend.dto.OrderDto;
import ru.mirea.carservicebackend.models.Order;

import java.util.List;

public interface OrderService {
    void setOrderState(Long orderId, Order.State state);
    List<OrderDto> getOrdersByUserId(Long userId);
}
