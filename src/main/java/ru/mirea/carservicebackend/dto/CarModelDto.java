package ru.mirea.carservicebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * The type Car model dto.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CarModelDto {
    /**
     * The type Car model brand dto.
     */
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CarModelBrandDto {
        private Long id;
        private String name;
    }

    /**
     * The type Car model car dto.
     */
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CarModelCarDto {
        private Long id;
        private String vin;
        private Long ownerId;
        private Integer manufactureYear;
        private Integer ordersCount;
    }

    /**
     * The type Car model service dto.
     */
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CarModelServiceDto {
        private Long id;
        private String name;
        private Integer duration;
        private Integer price;
        private Integer ordersCount;
    }

    private Long id;
    private String name;
    private CarModelBrandDto brand;
    private List<CarModelCarDto> cars;
    private List<CarModelServiceDto> services;
}
