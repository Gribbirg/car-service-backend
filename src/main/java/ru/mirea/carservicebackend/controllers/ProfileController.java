package ru.mirea.carservicebackend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mirea.carservicebackend.dto.CarDto;
import ru.mirea.carservicebackend.dto.OrderDto;
import ru.mirea.carservicebackend.dto.UserDto;
import ru.mirea.carservicebackend.models.Car;
import ru.mirea.carservicebackend.models.Order;
import ru.mirea.carservicebackend.models.User;
import ru.mirea.carservicebackend.services.CarService;
import ru.mirea.carservicebackend.services.OrderService;
import ru.mirea.carservicebackend.services.ProfileService;

import java.util.List;
import java.util.Objects;

/**
 * The type Profile controller.
 */
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/profile")
public class ProfileController {

    private final ProfileService profileService;
    private final CarService carService;
    private final OrderService orderService;

    /**
     * Gets user.
     *
     * @return the user
     */
    @GetMapping
    @ResponseBody
    public UserDto getUser() {
        return profileService.getCurrentUser();
    }

    /**
     * Gets user cars.
     *
     * @return the user cars
     */
    @GetMapping("/cars")
    @ResponseBody
    public List<CarDto> getUserCars() {
        Long userId = profileService.getCurrentUserId();
        return carService.getCarsByOwnerId(userId);
    }

    /**
     * Gets car.
     *
     * @param id the id
     * @return the car
     */
    @GetMapping("/cars/{id}")
    @ResponseBody
    public CarDto getCar(@PathVariable(name = "id") Long id) {
        CarDto car = carService.getCar(id);
        if (car == null)
            return null;

        if (!Objects.equals(car.getOwner().getId(), profileService.getCurrentUserId())) {
            return null;
        }

        return car;
    }

    /**
     * Add car.
     *
     * @param car the car
     */
    @PostMapping("/cars")
    @ResponseBody
    public void addCar(@RequestBody Car car) {
        car.setOwnerId(profileService.getCurrentUserId());
        carService.addCar(car);
    }

    /**
     * Gets user orders.
     *
     * @return the user orders
     */
    @GetMapping("/orders")
    @ResponseBody
    public List<OrderDto> getUserOrders() {
        Long userId = profileService.getCurrentUserId();
        return orderService.getOrdersByUserId(userId);
    }

    /**
     * Update.
     *
     * @param user the user
     */
    @PostMapping("/update")
    @ResponseBody
    public void update(@RequestParam User user) {
        profileService.updateUser(user.getName(), user.getSurname(), user.getEmail(), user.getPhone());
    }

    /**
     * Add order.
     *
     * @param carId       the car id
     * @param servicesIds the services ids
     */
    @PostMapping("/orders/{carId}")
    @ResponseBody
    public void addOrder(@PathVariable Long carId, @RequestBody List<Long> servicesIds) {
        profileService.addOrder(carId, servicesIds);
    }
}
