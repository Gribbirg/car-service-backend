package ru.mirea.carservicebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.mirea.carservicebackend.models.Order;
import ru.mirea.carservicebackend.models.User;

import java.util.Date;
import java.util.List;

/**
 * The type Order dto.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    /**
     * The type Order car dto.
     */
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OrderCarDto {
        /**
         * The type Order car model dto.
         */
        @Setter
        @Getter
        @AllArgsConstructor
        @NoArgsConstructor
        public static class OrderCarModelDto {
            private Long id;
            private String name;
        }

        /**
         * The type Order car brand dto.
         */
        @Setter
        @Getter
        @AllArgsConstructor
        @NoArgsConstructor
        public static class OrderCarBrandDto {
            private Long id;
            private String name;
        }

        private Long id;
        private String vin;
        private OrderCarModelDto model;
        private OrderCarBrandDto brand;
        private Integer manufactureYear;
    }

    /**
     * The type Order client dto.
     */
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OrderClientDto {
        private Long id;
        private User.Role role;
        private String name;
        private String surname;
        private String email;
        private String phone;
    }

    /**
     * The type Order service dto.
     */
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OrderServiceDto {
        private Long id;
        private String name;
        private Integer duration;
        private Integer price;
    }

    private Long id;
    private OrderCarDto car;
    private OrderClientDto client;
    private List<OrderServiceDto> services;
    private Order.State state;
    private Date creationDate;
    private Date finishedDate;
    private Integer price;
}
