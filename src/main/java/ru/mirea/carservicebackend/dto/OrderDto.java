package ru.mirea.carservicebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.mirea.carservicebackend.models.Order;
import ru.mirea.carservicebackend.models.User;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OrderCarDto {
        @Setter
        @Getter
        @AllArgsConstructor
        @NoArgsConstructor
        public static class OrderCarModelDto {
            private Long id;
            private String name;
        }

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
