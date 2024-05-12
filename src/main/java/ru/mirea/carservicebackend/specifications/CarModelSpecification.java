package ru.mirea.carservicebackend.specifications;

import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import ru.mirea.carservicebackend.models.CarModel;

@NoArgsConstructor
public class CarModelSpecification {
    public static Specification<CarModel> nameLikeWithBrand(Long brandId, String name) {
        return (root, query, builder) ->
                builder.and(
                        builder.equal(root.get("brandId"), brandId),
                        builder.like(root.get("name"), "%" + name + "%")
                );
    }

    public static Specification<CarModel> brandEquals(Long brandId) {
        return (root, query, builder) ->
                builder.equal(root.get("brandId"), brandId);
    }
}
