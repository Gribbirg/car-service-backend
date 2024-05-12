package ru.mirea.carservicebackend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mirea.carservicebackend.dto.CarBrandDto;
import ru.mirea.carservicebackend.dto.CarModelDto;
import ru.mirea.carservicebackend.services.CarService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/car_brands")
public class CarModelController {

    private final CarService carService;

    @GetMapping()
    @ResponseBody
    public List<CarBrandDto> getCarBrands(@RequestParam String name) {
        return carService.getBrandsByName(name);
    }

    @GetMapping("/{brandId}")
    @ResponseBody
    public List<CarModelDto> getCarModels(@PathVariable Long brandId, @RequestParam String name) {
        return carService.getModelsByName(brandId, name);
    }
}
