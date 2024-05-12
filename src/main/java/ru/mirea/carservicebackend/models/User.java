package ru.mirea.carservicebackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.mirea.carservicebackend.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    public enum Role {
        client,
        employee,
        admin
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "blocked")
    private Boolean blocked;

    @OneToMany(mappedBy = "ownerId")
    private List<Car> cars = new ArrayList<>();

    @OneToMany(mappedBy = "clientId")
    private List<Order> orders = new ArrayList<>();

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role=" + role +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", blocked=" + blocked +
                '}';
    }

    public UserDto toDto() {
        return new UserDto(
                id,
                role,
                name,
                surname,
                email,
                phone,
                cars.stream().map(car ->
                        new UserDto.UserCarDto(
                                car.getId(),
                                car.getVin(),
                                new UserDto.UserCarDto.UserCarModelDto(
                                        car.getModel().getId(),
                                        car.getModel().getName()
                                ),
                                new UserDto.UserCarDto.UserCarBrandDto(
                                        car.getModel().getBrand().getId(),
                                        car.getModel().getBrand().getName()
                                ),
                                car.getManufactureYear()
                        )
                ).toList(),
                orders.stream().map(order ->
                        new UserDto.UserOrderDto(
                                order.getId(),
                                order.services.stream().map(service ->
                                        new UserDto.UserOrderDto.UserOrderServiceDto(
                                                service.getId(),
                                                service.getName(),
                                                service.getPrice()
                                        )
                                ).toList(),
                                order.getState(),
                                order.getCreationDate(),
                                order.getFinishedDate()
                        )
                ).toList()
        );
    }
}
