package ru.mirea.carservicebackend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mirea.carservicebackend.dto.CarBrandDto;
import ru.mirea.carservicebackend.dto.CarModelDto;
import ru.mirea.carservicebackend.services.CarService;

import java.util.List;
import java.util.Objects;

/**
 * The type Car model controller.
 */
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/car_brands")
public class CarModelController {

    private final CarService carService;

    /**
     * Gets car brands.
     *
     * @param name the name
     * @return the car brands
     */
    @GetMapping()
    @ResponseBody
    public List<CarBrandDto> getCarBrands(@RequestParam(defaultValue = "") String name) {
        return carService.getBrandsByName(Objects.equals(name, "") ? null : name);
    }

    /**
     * Gets car models.
     *
     * @param brandId the brand id
     * @param name    the name
     * @return the car models
     */
    @GetMapping("/{brandId}")
    @ResponseBody
    public List<CarModelDto> getCarModels(@PathVariable Long brandId, @RequestParam(defaultValue = "") String name) {
        return carService.getModelsByName(brandId, Objects.equals(name, "") ? null : name);
    }
}
