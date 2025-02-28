package vn.test.vtibackend.service;

import vn.test.vtibackend.dto.request.ProductDetailCreateReq;
import vn.test.vtibackend.entity.ProductDetail;

import java.util.List;

public interface ProductDetailService {
    List<ProductDetail> getAll();
    ProductDetail create(ProductDetailCreateReq request);

}
