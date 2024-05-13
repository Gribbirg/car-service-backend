package ru.mirea.carservicebackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.mirea.carservicebackend.dto.CarBrandDto;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "car_brands")
public class CarBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "brandId")
    private List<CarModel> models = new ArrayList<>();

    public CarBrandDto toDto() {
        return new CarBrandDto(
                id,
                name,
                models.stream().map(model -> new CarBrandDto.CarBrandModelDto(
                        model.getId(),
                        model.getName(),
                        model.getCars().size(),
                        model.getServices().size())
                ).toList()
        );
    }
}
