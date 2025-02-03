package vn.test.vtibackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.test.vtibackend.entity.ProductOfferings;

public interface ProductOfferingRepo extends JpaRepository<ProductOfferings, Long> {
}
