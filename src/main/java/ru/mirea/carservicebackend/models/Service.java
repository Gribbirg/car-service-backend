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

    @OneToMany()
    private List<Order> orders = new ArrayList<>();
}
