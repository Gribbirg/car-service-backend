package ru.mirea.carservicebackend.services;

import ru.mirea.carservicebackend.dto.CarBrandDto;
import ru.mirea.carservicebackend.dto.CarDto;
import ru.mirea.carservicebackend.dto.CarModelDto;
import ru.mirea.carservicebackend.models.Car;
import ru.mirea.carservicebackend.models.CarBrand;
import ru.mirea.carservicebackend.models.CarModel;

import java.util.List;

/**
 * The interface Car service.
 */
public interface CarService {
    /**
     * Gets car.
     *
     * @param id the id
     * @return the car
     */
    CarDto getCar(Long id);

    /**
     * Add car.
     *
     * @param car the car
     */
    void addCar(Car car);

    /**
     * Gets brand.
     *
     * @param id the id
     * @return the brand
     */
    CarBrandDto getBrand(Long id);

    /**
     * Gets brands by name.
     *
     * @param name the name
     * @return the brands by name
     */
    List<CarBrandDto> getBrandsByName(String name);

    /**
     * Add brand.
     *
     * @param brand the brand
     */
    void addBrand(CarBrand brand);

    /**
     * Gets model.
     *
     * @param id the id
     * @return the model
     */
    CarModelDto getModel(Long id);

    /**
     * Gets models by name.
     *
     * @param brandId the brand id
     * @param name    the name
     * @return the models by name
     */
    List<CarModelDto> getModelsByName(Long brandId, String name);

    /**
     * Add model.
     *
     * @param model the model
     */
    void addModel(CarModel model);

    /**
     * Gets cars by owner id.
     *
     * @param ownerId the owner id
     * @return the cars by owner id
     */
    List<CarDto> getCarsByOwnerId(Long ownerId);
}
