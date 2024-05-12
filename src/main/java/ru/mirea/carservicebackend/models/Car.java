package ru.mirea.carservicebackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.mirea.carservicebackend.dto.CarDto;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vin")
    private String vin;

    @Column(name = "model_id")
    private Long modelId;

    @ManyToOne()
    @JoinColumn(name = "model_id", insertable = false, updatable = false)
    private CarModel model;

    @Column(name = "owner_id")
    private Long ownerId;

    @ManyToOne()
    @JoinColumn(name = "owner_id", insertable = false, updatable = false)
    private User owner;

    @Column(name = "manufacture_year")
    private Integer manufactureYear;

    @OneToMany()
    private List<Order> orders = new ArrayList<>();

    public CarDto toDto() {
        return new CarDto(
                id,
                vin,
                new CarDto.CarOwnerDto(
                        owner.getId(),
                        owner.getName(),
                        owner.getSurname(),
                        owner.getEmail(),
                        owner.getPhone()
                ),
                new CarDto.CarModelDto(
                        model.getId(),
                        model.getName()
                ),
                new CarDto.CarBrandDto(
                        model.getBrand().getId(),
                        model.getBrand().getName()
                ),
                orders
                        .stream()
                        .map(order ->
                                new CarDto.CarOrderDto(
                                        order.getId(),
                                        order.services.stream().map(service ->
                                                new CarDto.CarOrderDto.CarOrderServiceDto(
                                                        service.getId(),
                                                        service.getName(),
                                                        service.getPrice()
                                                )
                                        ).toList(),
                                        order.getState(),
                                        order.getCreationDate(),
                                        order.getFinishedDate()
                                )
                        )
                        .toList()
        );
    }
}
