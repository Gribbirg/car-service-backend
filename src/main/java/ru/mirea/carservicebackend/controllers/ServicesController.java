package ru.mirea.carservicebackend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.mirea.carservicebackend.dto.ServiceDto;
import ru.mirea.carservicebackend.services.ServiceService;

import java.util.List;

/**
 * The type Services controller.
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/services")
public class ServicesController {
    private final ServiceService serviceService;

    /**
     * Gets services.
     *
     * @param carModelIdStr the car model id str
     * @return the services
     */
    @GetMapping()
    @ResponseBody
    public List<ServiceDto> getServices(@RequestParam(defaultValue = "-1L") String carModelIdStr) {
        return serviceService.getServices(Long.getLong(carModelIdStr));
    }
}
