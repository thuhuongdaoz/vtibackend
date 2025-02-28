package vn.test.vtibackend.service.spec;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import vn.test.vtibackend.entity.Group;

public class GroupSpecification {
    public static Specification<Group> likeName(String name){
        return new Specification<Group>() {
            @Override
            public Predicate toPredicate(Root<Group> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if (name == null || name.isEmpty()){
                    return criteriaBuilder.conjunction();
                }
                return criteriaBuilder.like(root.get("name"), "%"+name+"%");
            }
        };
    }
}
