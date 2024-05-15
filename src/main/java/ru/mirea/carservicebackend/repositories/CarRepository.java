package ru.mirea.carservicebackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.carservicebackend.models.Car;

import java.util.List;

/**
 * The interface Car repository.
 */
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    /**
     * Find all by owner id list.
     *
     * @param ownerId the owner id
     * @return the list
     */
    List<Car> findAllByOwnerId(Long ownerId);
}
