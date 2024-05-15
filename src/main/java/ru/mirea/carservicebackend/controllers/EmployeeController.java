package ru.mirea.carservicebackend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mirea.carservicebackend.dto.OrderDto;
import ru.mirea.carservicebackend.models.CarBrand;
import ru.mirea.carservicebackend.models.CarModel;
import ru.mirea.carservicebackend.models.Order;
import ru.mirea.carservicebackend.models.Service;
import ru.mirea.carservicebackend.services.CarService;
import ru.mirea.carservicebackend.services.OrderService;
import ru.mirea.carservicebackend.services.ServiceService;

import java.util.List;

/**
 * The type Employee controller.
 */
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/employee")
public class EmployeeController {
    private final CarService carService;
    private final OrderService orderService;
    private final ServiceService serviceService;

    /**
     * Add brand.
     *
     * @param brand the brand
     */
    @PostMapping("/add_brand")
    @ResponseBody
    public void addBrand(@RequestBody CarBrand brand) {
        carService.addBrand(brand);
    }

    /**
     * Add model.
     *
     * @param model the model
     */
    @PostMapping("/add_model")
    @ResponseBody
    public void addModel(@RequestBody CarModel model) {
        carService.addModel(model);
    }

    /**
     * Add service.
     *
     * @param service the service
     */
    @PostMapping("/add_service")
    @ResponseBody
    public void addService(@RequestBody Service service) {
        serviceService.addService(service);
    }

    /**
     * Sets order state.
     *
     * @param orderId  the order id
     * @param stateStr the state str
     */
    @PostMapping("/set_state/{orderId}")
    @ResponseBody
    public void setOrderState(@PathVariable(name = "orderId") Long orderId, @RequestParam String stateStr) {
        Order.State state = Order.State.valueOf(stateStr);
        orderService.setOrderState(orderId, state);
    }

    @GetMapping("/orders")
    @ResponseBody
    public List<OrderDto> getOrders() {
        return orderService.getAllOrders();
    }
}
