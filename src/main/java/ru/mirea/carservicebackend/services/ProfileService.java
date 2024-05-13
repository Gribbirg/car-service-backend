package ru.mirea.carservicebackend.services;

import ru.mirea.carservicebackend.dto.CarDto;
import ru.mirea.carservicebackend.dto.OrderDto;
import ru.mirea.carservicebackend.dto.UserDto;

import java.util.List;

public interface ProfileService {

    Long getCurrentUserId();

    UserDto getCurrentUser();

    List<CarDto> getUserCars();

    List<OrderDto> getUserOrders();

    void addOrder(Long carId, List<Long> servicesIds);

    void updateUser(String name, String surname, String email, String phone);
}
