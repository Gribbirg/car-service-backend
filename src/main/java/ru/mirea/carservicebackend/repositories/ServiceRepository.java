package ru.mirea.carservicebackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.carservicebackend.models.Service;

import java.util.List;

/**
 * The interface Service repository.
 */
@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
    /**
     * Find all by car model id list.
     *
     * @param carModelId the car model id
     * @return the list
     */
    List<Service> findAllByCarModelId(Long carModelId);
}
