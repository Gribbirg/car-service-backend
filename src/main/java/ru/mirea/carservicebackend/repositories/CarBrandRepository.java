package ru.mirea.carservicebackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.mirea.carservicebackend.models.CarBrand;

public interface CarBrandRepository extends
        JpaRepository<CarBrand, Long>,
        JpaSpecificationExecutor<CarBrand> {
}
