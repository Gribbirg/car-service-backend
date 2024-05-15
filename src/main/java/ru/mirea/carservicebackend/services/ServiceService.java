package ru.mirea.carservicebackend.services;

import ru.mirea.carservicebackend.dto.ServiceDto;
import ru.mirea.carservicebackend.models.Service;

import java.util.List;

/**
 * The interface Service service.
 */
public interface ServiceService {
    /**
     * Add service.
     *
     * @param service the service
     */
    void addService(Service service);

    /**
     * Gets services.
     *
     * @param carModelId the car model id
     * @return the services
     */
    List<ServiceDto> getServices(Long carModelId);
}
