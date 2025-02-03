package vn.test.vtibackend.service;

import vn.test.vtibackend.entity.ProductOfferings;

import java.util.List;

public interface ProductOfferingService {
    ProductOfferings getById(Long id);
    List<ProductOfferings> getAll();
}
