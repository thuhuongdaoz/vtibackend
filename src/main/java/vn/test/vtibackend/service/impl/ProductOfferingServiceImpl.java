package vn.test.vtibackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.test.vtibackend.entity.ProductOfferings;
import vn.test.vtibackend.repository.ProductOfferingRepo;
import vn.test.vtibackend.service.ProductOfferingService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductOfferingServiceImpl implements ProductOfferingService {
    @Autowired
    private ProductOfferingRepo productOfferingRepo;
    @Override
    public ProductOfferings getById(Long id) {
        Optional<ProductOfferings> product = productOfferingRepo.findById(id);
        if (product.isEmpty()){
            throw new RuntimeException("khong tim thay product");
        }else {
            return product.get();
        }

    }

    @Override
    public List<ProductOfferings> getAll() {
        return productOfferingRepo.findAll();
    }
}
