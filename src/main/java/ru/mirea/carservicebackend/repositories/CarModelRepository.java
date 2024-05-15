package ru.mirea.carservicebackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.mirea.carservicebackend.models.CarModel;

import java.util.List;

/**
 * The interface Car model repository.
 */
@Repository
public interface CarModelRepository extends
        JpaRepository<CarModel, Long>,
        JpaSpecificationExecutor<CarModel> {

    /**
     * Find all by brand id list.
     *
     * @param brandId the brand id
     * @return the list
     */
    List<CarModel> findAllByBrandId(Long brandId);
}
