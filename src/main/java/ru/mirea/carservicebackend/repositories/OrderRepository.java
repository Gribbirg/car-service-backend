package ru.mirea.carservicebackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.carservicebackend.models.Order;

import java.util.List;

/**
 * The interface Order repository.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    /**
     * Find all by client id list.
     *
     * @param clientId the client id
     * @return the list
     */
    List<Order> findAllByClientId(Long clientId);
}
