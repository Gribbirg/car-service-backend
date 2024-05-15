package ru.mirea.carservicebackend.specifications;

import org.springframework.data.jpa.domain.Specification;
import ru.mirea.carservicebackend.models.CarBrand;

/**
 * The type Car brand specification.
 */
public class CarBrandSpecification {
    /**
     * Name like specification.
     *
     * @param name the name
     * @return the specification
     */
    public static Specification<CarBrand> nameLike(String name) {
        return (root, query, builder) ->
                builder.like(root.get("name"), "%" + name + "%");
    }
}
