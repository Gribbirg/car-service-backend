package ru.mirea.carservicebackend.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.mirea.carservicebackend.dto.CarBrandDto;
import ru.mirea.carservicebackend.dto.CarDto;
import ru.mirea.carservicebackend.dto.CarModelDto;
import ru.mirea.carservicebackend.models.Car;
import ru.mirea.carservicebackend.models.CarBrand;
import ru.mirea.carservicebackend.models.CarModel;
import ru.mirea.carservicebackend.repositories.CarBrandRepository;
import ru.mirea.carservicebackend.repositories.CarModelRepository;
import ru.mirea.carservicebackend.repositories.CarRepository;

import java.util.List;

import static ru.mirea.carservicebackend.specifications.CarBrandSpecification.nameLike;
import static ru.mirea.carservicebackend.specifications.CarModelSpecification.brandEquals;
import static ru.mirea.carservicebackend.specifications.CarModelSpecification.nameLikeWithBrand;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final CarBrandRepository brandRepository;
    private final CarModelRepository modelRepository;

    @Override
    public CarDto getCar(Long id) {
        return carRepository.findById(id).orElseThrow().toDto();
    }

    @Override
    public void addCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public CarBrandDto getBrand(Long id) {
        return brandRepository.findById(id).orElseThrow().toDto();
    }

    @Override
    public List<CarBrandDto> getBrandsByName(String name) {
        Specification<CarBrand> filters = Specification
                .where(name == null ? null : nameLike(name));
        return brandRepository.findAll(filters).stream().map(CarBrand::toDto).toList();
    }

    @Override
    public void addBrand(CarBrand brand) {
        brandRepository.save(brand);
    }

    @Override
    public CarModelDto getModel(Long id) {
        return modelRepository.findById(id).orElseThrow().toDto();
    }

    @Override
    public List<CarModelDto> getModelsByName(Long brandId, String name) {
        Specification<CarModel> filters = Specification
                .where(name == null ? brandEquals(brandId) : nameLikeWithBrand(brandId, name));
        return modelRepository.findAll(filters).stream().map(CarModel::toDto).toList();
    }

    @Override
    public void addModel(CarModel model) {
        modelRepository.save(model);
    }

    @Override
    public List<CarDto> getCarsByOwnerId(Long ownerId) {
        return carRepository.findAllByOwnerId(ownerId).stream().map(Car::toDto).toList();
    }
}
