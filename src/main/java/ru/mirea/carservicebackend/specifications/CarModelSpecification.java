package ru.mirea.carservicebackend.specifications;

import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import ru.mirea.carservicebackend.models.CarModel;

/**
 * The type Car model specification.
 */
@NoArgsConstructor
public class CarModelSpecification {
    /**
     * Name like with brand specification.
     *
     * @param brandId the brand id
     * @param name    the name
     * @return the specification
     */
    public static Specification<CarModel> nameLikeWithBrand(Long brandId, String name) {
        return (root, query, builder) ->
                builder.and(
                        builder.equal(root.get("brandId"), brandId),
                        builder.like(root.get("name"), "%" + name + "%")
                );
    }

    /**
     * Brand equals specification.
     *
     * @param brandId the brand id
     * @return the specification
     */
    public static Specification<CarModel> brandEquals(Long brandId) {
        return (root, query, builder) ->
                builder.equal(root.get("brandId"), brandId);
    }
}
