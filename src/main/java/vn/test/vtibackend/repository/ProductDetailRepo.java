package vn.test.vtibackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.test.vtibackend.entity.ProductDetail;

public interface ProductDetailRepo extends JpaRepository<ProductDetail, Long> {
    
}
