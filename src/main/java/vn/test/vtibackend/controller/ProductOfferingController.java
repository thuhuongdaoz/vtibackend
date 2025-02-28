package vn.test.vtibackend.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.test.vtibackend.dto.request.ProductOfferingCreateReq;
import vn.test.vtibackend.dto.request.ProductOfferingFilter;
import vn.test.vtibackend.dto.response.ProductOfferingRes;
import vn.test.vtibackend.entity.ProductOfferings;
import vn.test.vtibackend.service.ProductOfferingService;

import java.util.List;
import java.util.ListIterator;

@RestController
@RequiredArgsConstructor
public class ProductOfferingController {

    private final ProductOfferingService productOfferingService;
    private final ModelMapper modelMapper;

    @GetMapping("/filter")
    public ResponseEntity<List<ProductOfferingRes>> filter(
            ProductOfferingFilter productOfferingFilter
//    @RequestParam(name = "name", required = false) String name,
//                                                         @RequestParam(name = "minPrice", required = false) Long minPrice,
//                                                         @RequestParam(name = "maxPrice", required = false) Long maxPrice,
//                                                         @RequestParam(name = "color", required = false) String color,
//                                                         @RequestParam(name = "status", required = false) String status
            ){

        List<ProductOfferings> productOfferings = productOfferingService.filter(productOfferingFilter.getName(),
                productOfferingFilter.getMinPrice(), productOfferingFilter.getMaxPrice(), productOfferingFilter.getColor(), productOfferingFilter.getStatus());
//        List<ProductOfferings> productOfferings = productOfferingService.filter(name, minPrice,  maxPrice,  color,  status);
        List<ProductOfferingRes> productOfferingResList = modelMapper.map(productOfferings, new TypeToken<List<ProductOfferingRes>>(){}.getType());
        return ResponseEntity.ok(productOfferingResList);
    }
    @GetMapping("/products")
    private ResponseEntity<ProductOfferingRes> getById(Long id) {
        id = 1L;
        ProductOfferings productOfferings = productOfferingService.getById(id);
        ProductOfferingRes productOfferingRes = modelMapper.map(productOfferings, ProductOfferingRes.class);
        return ResponseEntity.ok(productOfferingRes);

    }

    @GetMapping("/all-products")
    public ResponseEntity<List<ProductOfferings>> getAll() {
        List<ProductOfferings> productOfferings = productOfferingService.getAll();
        return ResponseEntity.ok(productOfferings);
    }

    @GetMapping("/search-products-name")
    public ResponseEntity<List<ProductOfferings>> searchByName(String name){
        name = "Product_2";
        List<ProductOfferings> productOfferings = productOfferingService.searchByName(name);
        return ResponseEntity.ok(productOfferings);
    }

    @GetMapping("/search-products-name-price")
    public ResponseEntity<List<ProductOfferings>> searchByNameAndPrice(String name, Long price){
        name = "Product_4";
        price = 1000L;
        List<ProductOfferings> productOfferings = productOfferingService.searchByNameAndPrice(name, price);
        return ResponseEntity.ok(productOfferings);
    }
    @PostMapping("/products")
    public ResponseEntity<ProductOfferings> create(@RequestBody ProductOfferingCreateReq request){
        ProductOfferings product = productOfferingService.create(request);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ProductOfferings> update(@PathVariable Long id, @RequestBody ProductOfferings productOfferings){
        ProductOfferings product = productOfferingService.updateProduct(id, productOfferings);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/search-products-brand")
    public ResponseEntity<List<ProductOfferings>> searchByBrand(String brand){
        brand = "samsung";
        List<ProductOfferings> productOfferings = productOfferingService.searchByBrand(brand);
        return ResponseEntity.ok(productOfferings);
    }
}
