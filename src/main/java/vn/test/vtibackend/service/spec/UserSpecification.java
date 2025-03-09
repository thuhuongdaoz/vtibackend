package vn.test.vtibackend.service.spec;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import vn.test.vtibackend.entity.Group;
import vn.test.vtibackend.entity.User;

public class UserSpecification {
    public static Specification<User> likeName(String name){
        return new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if (name == null || name.isEmpty()){
                    return criteriaBuilder.conjunction();
                }
                return criteriaBuilder.like(root.get("name"), "%"+name+"%");
            }
        };
    }

    public static Specification<User> likeEmail(String email){
        return new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if (email == null || email.isEmpty()){
                    return criteriaBuilder.conjunction();
                }
                return criteriaBuilder.like(root.get("email"), "%"+email+"%");
            }
        };
    }

    public static Specification<User> equalRole(String role){
        return new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if (role == null || role.isEmpty()){
                    return criteriaBuilder.conjunction();
                }
                return criteriaBuilder.equal(root.get("role"), role);
            }
        };
    }
}
