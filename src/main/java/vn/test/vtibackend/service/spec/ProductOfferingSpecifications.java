package vn.test.vtibackend.service.spec;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import vn.test.vtibackend.entity.ProductOfferings;

public class ProductOfferingSpecifications {
    public static Specification<ProductOfferings> likeName(String name) {
        return new Specification<ProductOfferings>() {
            @Override
            public Predicate toPredicate(Root<ProductOfferings> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if (name == null || name.isEmpty()){
                    return criteriaBuilder.conjunction();
                }
                return criteriaBuilder.like(root.get("name"), "%"+name+"%");
            }
        };
    }

    public static Specification<ProductOfferings> minPrice(Long minPrice) {
        return new Specification<ProductOfferings>() {
            @Override
            public Predicate toPredicate(Root<ProductOfferings> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if (minPrice == null){
                    return criteriaBuilder.conjunction();
                }
                return criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
            }
        };
    }

    public static Specification<ProductOfferings> maxPrice(Long maxPrice) {
        return (root, query, criteriaBuilder) -> {
            if (maxPrice == null){
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
        };

    }
    public static Specification<ProductOfferings> likeColor(String color) {
        return (root, query, criteriaBuilder) -> {
            if (color == null || color.isEmpty()){
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(root.get("color"), "%"+color+"%");
        };
    }

    public static Specification<ProductOfferings> equalStatus(String status) {
        return (root, query, criteriaBuilder) -> {
            if (status == null || status.isEmpty()){
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("status"), status);
        };
    }


}
