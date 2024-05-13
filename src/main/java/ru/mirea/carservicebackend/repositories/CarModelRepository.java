package ru.mirea.carservicebackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.mirea.carservicebackend.models.CarModel;

import java.util.List;

@Repository
public interface CarModelRepository extends
        JpaRepository<CarModel, Long>,
        JpaSpecificationExecutor<CarModel> {

    List<CarModel> findAllByBrandId(Long brandId);
}
