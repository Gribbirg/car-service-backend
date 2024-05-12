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
import ru.mirea.carservicebackend.services.ProfileService;

import java.util.List;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/profile")
public class ProfileController {

    private final ProfileService profileService;
    private final CarService carService;

    @GetMapping
    @ResponseBody
    public UserDto getUser() {
        return profileService.getCurrentUser();
    }

    @GetMapping("/cars")
    @ResponseBody
    public List<CarDto> getUserCars() {
        return profileService.getUserCars();
    }

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

    @PostMapping("/cars")
    @ResponseBody
    public void addCar(@RequestBody Car car) {
        car.setOwnerId(profileService.getCurrentUserId());
        carService.addCar(car);
    }

    @GetMapping("/orders")
    @ResponseBody
    public List<OrderDto> getUserOrders() {
        return profileService.getUserOrders();
    }

    @PostMapping("/update")
    @ResponseBody
    public void update(@RequestParam User user) {
        profileService.updateUser(user.getName(), user.getSurname(), user.getEmail(), user.getPhone());
    }

    @PostMapping("/orders")
    @ResponseBody
    public void addOrder(@RequestParam Order order, @RequestParam List<Long> servicesIds) {
        profileService.addOrder(order, servicesIds);
    }
}
