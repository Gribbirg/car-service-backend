package ru.mirea.carservicebackend.services;

import ru.mirea.carservicebackend.dto.CarBrandDto;
import ru.mirea.carservicebackend.dto.CarDto;
import ru.mirea.carservicebackend.dto.CarModelDto;
import ru.mirea.carservicebackend.models.Car;

import java.util.List;

public interface CarService {
    CarDto getCar(Long id);

    void addCar(Car car);

    CarBrandDto getBrand(Long id);

    List<CarBrandDto> getBrandsByName(String name);

    CarModelDto getModel(Long id);

    List<CarModelDto> getModelsByName(Long brandId, String name);
}
