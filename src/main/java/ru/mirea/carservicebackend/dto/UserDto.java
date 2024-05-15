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
 * The type User dto.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    /**
     * The type User car dto.
     */
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserCarDto {
        /**
         * The type User car model dto.
         */
        @Setter
        @Getter
        @AllArgsConstructor
        @NoArgsConstructor
        public static class UserCarModelDto {
            private Long id;
            private String name;
        }

        /**
         * The type User car brand dto.
         */
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

    /**
     * The type User order dto.
     */
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserOrderDto {
        /**
         * The type User order service dto.
         */
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
