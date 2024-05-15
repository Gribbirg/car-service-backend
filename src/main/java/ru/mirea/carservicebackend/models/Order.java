package ru.mirea.carservicebackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.mirea.carservicebackend.dto.OrderDto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The type Order.
 */
@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    /**
     * The enum State.
     */
    public enum State {
        /**
         * Created state.
         */
        created,
        /**
         * Accepted state.
         */
        accepted,
        /**
         * Started state.
         */
        started,
        /**
         * Finished state.
         */
        finished,
        /**
         * Closed state.
         */
        closed,
        /**
         * Failed state.
         */
        failed
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_id")
    private Long clientId;

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

    /**
     * The Services.
     */
    @ManyToMany
    @JoinTable(
            name = "orders_services",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    List<Service> services = new ArrayList<>();

    /**
     * To dto order dto.
     *
     * @return the order dto
     */
    public OrderDto toDto() {
        return new OrderDto(
                id,
                new OrderDto.OrderCarDto(
                        car.getId(),
                        car.getVin(),
                        new OrderDto.OrderCarDto.OrderCarModelDto(
                                car.getModel().getId(),
                                car.getModel().getName()
                        ),
                        new OrderDto.OrderCarDto.OrderCarBrandDto(
                                car.getModel().getBrand().getId(),
                                car.getModel().getBrand().getName()
                        ),
                        car.getManufactureYear()
                ),
                new OrderDto.OrderClientDto(
                        client.getId(),
                        client.getRole(),
                        client.getName(),
                        client.getSurname(),
                        client.getEmail(),
                        client.getPhone()
                ),
                services.stream().map(service -> new OrderDto.OrderServiceDto(
                        service.getId(),
                        service.getName(),
                        service.getDuration(),
                        service.getPrice()
                )).toList(),
                state,
                creationDate,
                finishedDate,
                services.stream().mapToInt(Service::getPrice).sum()
        );
    }
}
