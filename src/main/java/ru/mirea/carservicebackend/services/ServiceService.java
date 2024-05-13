package ru.mirea.carservicebackend.services;

import ru.mirea.carservicebackend.dto.ServiceDto;
import ru.mirea.carservicebackend.models.Service;

import java.util.List;

public interface ServiceService {
    void addService(Service service);
    List<ServiceDto> getServices(Long carModelId);
}
