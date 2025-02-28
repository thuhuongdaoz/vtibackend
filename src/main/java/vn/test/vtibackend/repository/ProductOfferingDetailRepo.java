package vn.test.vtibackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.test.vtibackend.entity.ProductDetail;
import vn.test.vtibackend.entity.ProductOfferingDetail;
import vn.test.vtibackend.entity.ProductOfferings;

import java.util.Optional;

public interface ProductOfferingDetailRepo extends JpaRepository<ProductOfferingDetail, Long> {
    void deleteByProductOfferings(ProductOfferings productOfferings);
    Optional<ProductOfferingDetail> findByProductOfferingsAndProductDetail(ProductOfferings productOfferings, ProductDetail productDetail);
}
