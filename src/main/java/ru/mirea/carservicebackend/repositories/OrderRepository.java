package ru.mirea.carservicebackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.carservicebackend.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}