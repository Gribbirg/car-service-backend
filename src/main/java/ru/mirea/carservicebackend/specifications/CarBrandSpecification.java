package ru.mirea.carservicebackend.specifications;

import org.springframework.data.jpa.domain.Specification;
import ru.mirea.carservicebackend.models.CarBrand;

public class CarBrandSpecification {
    public static Specification<CarBrand> nameLike(String name) {
        return (root, query, builder) ->
                builder.like(root.get("name"), "%" + name + "%");
    }
}
