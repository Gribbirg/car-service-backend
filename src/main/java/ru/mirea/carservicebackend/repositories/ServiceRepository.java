package ru.mirea.carservicebackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.carservicebackend.models.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
