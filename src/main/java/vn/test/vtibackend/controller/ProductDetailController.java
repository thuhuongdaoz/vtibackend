package vn.test.vtibackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vn.test.vtibackend.dto.request.ProductDetailCreateReq;
import vn.test.vtibackend.entity.ProductDetail;
import vn.test.vtibackend.entity.ProductOfferings;
import vn.test.vtibackend.service.ProductDetailService;
import vn.test.vtibackend.service.ProductOfferingService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductDetailController {


    private final ProductDetailService productDetailService;

    @GetMapping("/product-details")
    public ResponseEntity<List<ProductDetail>> getAll(){
//        List<ProductDetail> productDetails = productDetailService.getAll();
        return ResponseEntity.ok(null);
    }
//    @PostMapping("/product-detail")
//    public ResponseEntity<ProductDetail> create(@RequestBody ProductDetailCreateReq request){
//        ProductDetail productDetail = productDetailService.create(request);
//        return ResponseEntity.ok(productDetail);
//    }
}
