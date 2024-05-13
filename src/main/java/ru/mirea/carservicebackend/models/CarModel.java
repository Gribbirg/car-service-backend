package ru.mirea.carservicebackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.mirea.carservicebackend.dto.CarModelDto;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "car_models")
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "brand_id")
    private Long brandId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id", insertable = false, updatable = false)
    private CarBrand brand;

    @OneToMany(mappedBy = "modelId")
    private List<Car> cars = new ArrayList<>();

    @OneToMany(mappedBy = "carModelId")
    private List<Service> services = new ArrayList<>();

    public CarModelDto toDto() {
        return new CarModelDto(
                id,
                name,
                new CarModelDto.CarModelBrandDto(
                        brand.getId(),
                        brand.getName()
                ),
                cars.stream().map(car -> new CarModelDto.CarModelCarDto(
                        car.getId(),
                        car.getVin(),
                        car.getOwnerId(),
                        car.getManufactureYear(),
                        car.getOrders().size()
                )).toList(),
                services.stream().map(service -> new CarModelDto.CarModelServiceDto(
                        service.getId(),
                        service.getName(),
                        service.getDuration(),
                        service.getPrice(),
                        service.getOrders().size()
                )).toList()
        );
    }
}
