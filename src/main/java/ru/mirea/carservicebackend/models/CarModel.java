package ru.mirea.carservicebackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @ManyToOne()
    @JoinColumn(name = "brand_id", insertable = false, updatable = false)
    private CarBrand brand;

    @OneToMany
    private List<Car> cars = new ArrayList<>();

    @OneToMany
    private List<Service> services = new ArrayList<>();
}
