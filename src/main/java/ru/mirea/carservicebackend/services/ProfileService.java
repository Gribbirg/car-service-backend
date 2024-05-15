package ru.mirea.carservicebackend.services;

import ru.mirea.carservicebackend.dto.CarDto;
import ru.mirea.carservicebackend.dto.OrderDto;
import ru.mirea.carservicebackend.dto.UserDto;

import java.util.List;

/**
 * The interface Profile service.
 */
public interface ProfileService {

    /**
     * Gets current user id.
     *
     * @return the current user id
     */
    Long getCurrentUserId();

    /**
     * Gets current user.
     *
     * @return the current user
     */
    UserDto getCurrentUser();

    /**
     * Gets user cars.
     *
     * @return the user cars
     */
    List<CarDto> getUserCars();

    /**
     * Gets user orders.
     *
     * @return the user orders
     */
    List<OrderDto> getUserOrders();

    /**
     * Add order.
     *
     * @param carId       the car id
     * @param servicesIds the services ids
     */
    void addOrder(Long carId, List<Long> servicesIds);

    /**
     * Update user.
     *
     * @param name    the name
     * @param surname the surname
     * @param email   the email
     * @param phone   the phone
     */
    void updateUser(String name, String surname, String email, String phone);
}
