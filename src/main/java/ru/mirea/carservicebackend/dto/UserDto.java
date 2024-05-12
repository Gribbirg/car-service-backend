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
public class UserDto {
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserCarDto {
        @Setter
        @Getter
        @AllArgsConstructor
        @NoArgsConstructor
        public static class UserCarModelDto {
            private Long id;
            private String name;
        }

        @Setter
        @Getter
        @AllArgsConstructor
        @NoArgsConstructor
        public static class UserCarBrandDto {
            private Long id;
            private String name;
        }

        private Long id;
        private String vin;
        private UserCarModelDto model;
        private UserCarBrandDto brand;
        private Integer manufactureYear;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserOrderDto {
        @Setter
        @Getter
        @AllArgsConstructor
        @NoArgsConstructor
        public static class UserOrderServiceDto {
            private Long id;
            private String name;
            private Integer price;
        }

        private Long id;
        private List<UserOrderServiceDto> services;
        private Order.State state;
        private Date creationDate;
        private Date finishedDate;
    }

    private Long id;
    private User.Role role;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private List<UserCarDto> cars;
    private List<UserOrderDto> orders;
}
