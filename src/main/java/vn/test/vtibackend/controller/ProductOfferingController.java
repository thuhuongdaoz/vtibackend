package vn.test.vtibackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.test.vtibackend.entity.ProductOfferings;
import vn.test.vtibackend.service.ProductOfferingService;

@RestController
public class ProductOfferingController {
    @Autowired
    private ProductOfferingService productOfferingService;

    @GetMapping("/products")
    public ResponseEntity<ProductOfferings> getById(Long id) {
        id = 1l;
        ProductOfferings productOfferings = productOfferingService.getById(id);
        return ResponseEntity.ok(productOfferings);

    }
}
