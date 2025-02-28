package vn.test.vtibackend.service;

import vn.test.vtibackend.dto.request.AssignProductDetailReq;
import vn.test.vtibackend.entity.ProductOfferings;

public interface ProductOfferingDetailService {
    ProductOfferings assignProductDetail(AssignProductDetailReq request);
}
