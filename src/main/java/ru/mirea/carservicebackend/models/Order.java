package ru.mirea.carservicebackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    public enum State {
        created,
        accepted,
        started,
        finished,
        closed,
        failed
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_id")
    private Long brandId;

    @ManyToOne()
    @JoinColumn(name = "client_id", insertable = false, updatable = false)
    private User client;

    @Column(name = "car_id")
    private Long carId;

    @ManyToOne()
    @JoinColumn(name = "car_id", insertable = false, updatable = false)
    private Car car;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private State state;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "finished_date")
    private Date finishedDate;
}
