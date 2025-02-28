package vn.test.vtibackend.service;

import vn.test.vtibackend.dto.request.ProductOfferingCreateReq;
import vn.test.vtibackend.entity.ProductOfferings;

import java.util.List;

public interface ProductOfferingService {
    ProductOfferings getById(Long id);
    List<ProductOfferings> getAll();
    List<ProductOfferings> searchByName(String name);
    List<ProductOfferings> searchByNameAndPrice(String name, Long price);
    ProductOfferings create(ProductOfferingCreateReq request);
    ProductOfferings updateProduct(Long id, ProductOfferings productOfferings);
    List<ProductOfferings> searchByBrand(String brand);
    List<ProductOfferings> filter(String name, Long minPrice, Long maxPrice, String color, String status);

}
