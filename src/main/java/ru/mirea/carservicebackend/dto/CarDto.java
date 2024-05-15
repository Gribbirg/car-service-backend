package ru.mirea.carservicebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.mirea.carservicebackend.models.Order;

import java.util.Date;
import java.util.List;

/**
 * The type Car dto.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
    /**
     * The type Car owner dto.
     */
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CarOwnerDto {
        private Long id;
        private String name;
        private String surname;
        private String email;
        private String phone;
    }

    /**
     * The type Car model dto.
     */
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CarModelDto {
        private Long id;
        private String name;
    }

    /**
     * The type Car brand dto.
     */
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CarBrandDto {
        private Long id;
        private String name;
    }

    /**
     * The type Car order dto.
     */
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CarOrderDto {
        /**
         * The type Car order service dto.
         */
        @Setter
        @Getter
        @AllArgsConstructor
        @NoArgsConstructor
        public static class CarOrderServiceDto {
            private Long id;
            private String name;
            private Integer price;
        }

        private Long id;
        private List<CarOrderServiceDto> services;
        private Order.State state;
        private Date creationDate;
        private Date finishedDate;
    }

    private Long id;
    private String vin;
    private CarOwnerDto owner;
    private CarModelDto model;
    private CarBrandDto brand;
    private List<CarOrderDto> orders;
}
