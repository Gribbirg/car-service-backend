package ru.mirea.carservicebackend.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mirea.carservicebackend.dto.ServiceDto;
import ru.mirea.carservicebackend.repositories.ServiceRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;

    @Override
    public void addService(ru.mirea.carservicebackend.models.Service service) {
        serviceRepository.save(service);
    }

    @Override
    public List<ServiceDto> getServices(Long carModelId) {
        if (carModelId == null || carModelId == -1) {
            return serviceRepository
                    .findAll()
                    .stream()
                    .map(ru.mirea.carservicebackend.models.Service::toDto)
                    .toList();
        }
        return serviceRepository
                .findAllByCarModelId(carModelId)
                .stream()
                .map(ru.mirea.carservicebackend.models.Service::toDto)
                .toList();
    }
}
