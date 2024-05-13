package ru.mirea.carservicebackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.mirea.carservicebackend.dto.ServiceDto;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "duration_days")
    private Integer duration;

    @Column(name = "price")
    private Integer price;

    @Column(name = "car_model_id")
    private Long carModelId;

    @ManyToOne()
    @JoinColumn(name = "car_model_id", insertable = false, updatable = false)
    private CarModel carModel;

    @ManyToMany()
    @JoinTable(
            name = "orders_services",
            joinColumns = @JoinColumn(name = "service_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    private List<Order> orders = new ArrayList<>();

    public ServiceDto toDto() {
        return new ServiceDto(
                id,
                name,
                duration,
                price,
                new ServiceDto.ServiceCarModelDto(
                        carModel.getId(),
                        carModel.getName()
                ),
                orders.stream().map(order ->
                        new ServiceDto.ServiceOrderDto(
                                order.getId(),
                                order.getState(),
                                order.getCreationDate(),
                                order.getFinishedDate()
                        )
                ).toList()
        );
    }
}
