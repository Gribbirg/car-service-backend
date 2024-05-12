package ru.mirea.carservicebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CarModelDto {
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CarModelBrandDto {
        private Long id;
        private String name;
    }

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
