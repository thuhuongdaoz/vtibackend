package vn.test.vtibackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vn.test.vtibackend.dto.request.AssignProductDetailReq;
import vn.test.vtibackend.entity.ProductOfferings;
import vn.test.vtibackend.service.ProductOfferingDetailService;

@RestController
@RequiredArgsConstructor
public class ProductOfferingDetailController {

    private final ProductOfferingDetailService productOfferingDetailService;

    @PostMapping("assign-product-detail")
    public ResponseEntity<ProductOfferings> assignProductDetail(@RequestBody AssignProductDetailReq request){
        ProductOfferings productOfferings = productOfferingDetailService.assignProductDetail(request);
        return ResponseEntity.ok(productOfferings);
    }
}
