package ru.mirea.carservicebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * The type Car brand dto.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CarBrandDto {
    /**
     * The type Car brand model dto.
     */
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CarBrandModelDto {
        private Long id;
        private String name;
        private Integer carsCount;
        private Integer servicesCount;
    }

    private Long id;
    private String name;
    private List<CarBrandModelDto> models;
}
