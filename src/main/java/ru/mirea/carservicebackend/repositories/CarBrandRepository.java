package ru.mirea.carservicebackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.mirea.carservicebackend.models.CarBrand;

/**
 * The interface Car brand repository.
 */
@Repository
public interface CarBrandRepository extends
        JpaRepository<CarBrand, Long>,
        JpaSpecificationExecutor<CarBrand> {
}
