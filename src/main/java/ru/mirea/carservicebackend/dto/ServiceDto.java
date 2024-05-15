package ru.mirea.carservicebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.mirea.carservicebackend.models.Order;

import java.util.Date;
import java.util.List;

/**
 * The type Service dto.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDto {
    /**
     * The type Service car model dto.
     */
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ServiceCarModelDto {
        private Long id;
        private String name;
    }

    /**
     * The type Service order dto.
     */
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ServiceOrderDto {
        private Long id;
        private Order.State state;
        private Date creationDate;
        private Date finishedDate;
    }

    private Long id;
    private String name;
    private Integer duration;
    private Integer price;
    private ServiceCarModelDto carModel;
    private List<ServiceOrderDto> orders;
}
