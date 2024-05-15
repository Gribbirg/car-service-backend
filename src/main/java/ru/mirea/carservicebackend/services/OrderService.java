package ru.mirea.carservicebackend.services;

import ru.mirea.carservicebackend.dto.OrderDto;
import ru.mirea.carservicebackend.models.Order;

import java.util.List;

/**
 * The interface Order service.
 */
public interface OrderService {
    /**
     * Sets order state.
     *
     * @param orderId the order id
     * @param state   the state
     */
    void setOrderState(Long orderId, Order.State state);

    /**
     * Gets orders by user id.
     *
     * @param userId the user id
     * @return the orders by user id
     */
    List<OrderDto> getOrdersByUserId(Long userId);

    List<OrderDto> getAllOrders();
}
