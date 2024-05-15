package ru.mirea.carservicebackend.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mirea.carservicebackend.dto.OrderDto;
import ru.mirea.carservicebackend.models.Order;
import ru.mirea.carservicebackend.repositories.OrderRepository;

import java.util.Date;
import java.util.List;

/**
 * The type Order service.
 */
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public void setOrderState(Long orderId, Order.State state) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        order.setState(state);
        if (state == Order.State.finished) {
            order.setFinishedDate(new Date());
        }
        orderRepository.save(order);
    }

    @Override
    public List<OrderDto> getOrdersByUserId(Long userId) {
        return orderRepository.findAllByClientId(userId).stream().map(Order::toDto).toList();
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll().stream().map(Order::toDto).toList();
    }
}
