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
}
