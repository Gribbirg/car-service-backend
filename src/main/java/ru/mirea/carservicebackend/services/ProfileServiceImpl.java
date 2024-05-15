package ru.mirea.carservicebackend.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.mirea.carservicebackend.config.AppUserDetails;
import ru.mirea.carservicebackend.dto.CarDto;
import ru.mirea.carservicebackend.dto.OrderDto;
import ru.mirea.carservicebackend.dto.UserDto;
import ru.mirea.carservicebackend.models.Car;
import ru.mirea.carservicebackend.models.Order;
import ru.mirea.carservicebackend.models.User;
import ru.mirea.carservicebackend.repositories.OrderRepository;
import ru.mirea.carservicebackend.repositories.ServiceRepository;
import ru.mirea.carservicebackend.repositories.UserRepository;

import java.util.Date;
import java.util.List;

/**
 * The type Profile service.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ProfileServiceImpl implements ProfileService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final ServiceRepository serviceRepository;

    @Override
    public Long getCurrentUserId() {
        return getCurrentAuthUser().getId();
    }

    @Override
    public UserDto getCurrentUser() {
        log.info(getCurrentAuthUserActual().toString());
        return getCurrentAuthUserActual().toDto();
    }

    @Override
    public List<CarDto> getUserCars() {
        return getCurrentAuthUser().getCars().stream().map(Car::toDto).toList();
    }

    @Override
    public List<OrderDto> getUserOrders() {
        return getCurrentAuthUser().getOrders().stream().map(Order::toDto).toList();
    }

    @Override
    public void addOrder(Long carId, List<Long> servicesIds) {
        Order order = new Order();
        order.setCarId(carId);
        order.setCreationDate(new Date());
        order.setClientId(getCurrentUserId());
        order.setServices(serviceRepository.findAllById(servicesIds));
        orderRepository.save(order);
    }

    @Override
    public void updateUser(String name, String surname, String email, String phone) {
        User user = getCurrentAuthUserActual();
        if (name != null) user.setName(name);
        if (email != null) user.setEmail(email);
        if (surname != null) user.setSurname(surname);
        if (phone != null) user.setPhone(phone);
        userRepository.save(user);
    }

    private User getCurrentAuthUserActual() {
        return userRepository.findById(getCurrentAuthUser().getId()).orElseThrow();
    }

    private User getCurrentAuthUser() {
        return ((AppUserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal()
        ).getUser();
    }
}
