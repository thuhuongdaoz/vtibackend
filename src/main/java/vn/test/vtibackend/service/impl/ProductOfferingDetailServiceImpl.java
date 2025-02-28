package vn.test.vtibackend.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.test.vtibackend.dto.request.AssignProductDetailReq;
import vn.test.vtibackend.entity.ProductDetail;
import vn.test.vtibackend.entity.ProductOfferingDetail;
import vn.test.vtibackend.entity.ProductOfferings;
import vn.test.vtibackend.repository.ProductDetailRepo;
import vn.test.vtibackend.repository.ProductOfferingDetailRepo;
import vn.test.vtibackend.repository.ProductOfferingRepo;
import vn.test.vtibackend.service.ProductOfferingDetailService;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ProductOfferingDetailServiceImpl implements ProductOfferingDetailService {

    private final ProductOfferingDetailRepo productOfferingDetailRepo;

    private final ProductOfferingRepo productOfferingRepo;

    private final ProductDetailRepo productDetailRepo;

//    @Override
//    public ProductOfferings assignProductDetail(AssignProductDetailReq request) {
//        if (request.getProductOfferingId() == null){
//            throw new RuntimeException("productOfferingId not null");
//        }
//        if (request.getProductDetailIds() == null || request.getProductDetailIds().isEmpty()){
//            throw new RuntimeException("productDetailIds not null or empty");
//        }
//
//        Optional<ProductOfferings> productOfferingsOptional = productOfferingRepo.findById(request.getProductOfferingId());
//        if (productOfferingsOptional.isEmpty()){
//            throw new RuntimeException("productOfferingId not found");
//        }
//        ProductOfferings productOfferings = productOfferingsOptional.get();
//        List<ProductDetail> productDetails = productDetailRepo.findAllById(request.getProductDetailIds());
//        if(productDetails.isEmpty()){
//            throw new RuntimeException("productDetailIds not found");
//        }
//
//        List<ProductOfferingDetail> productOfferingDetails = new ArrayList<>();
//        for (int i = 0; i < request.getProductDetailIds().size(); i++) {
//            ProductOfferingDetail productOfferingDetail = new ProductOfferingDetail();
//            productOfferingDetail.setProductOfferings(productOfferings);
//            productOfferingDetail.setProductDetail(productDetails.get(i));
//            productOfferingDetails.add(productOfferingDetail);
//        }
//        productOfferingDetailRepo.saveAll(productOfferingDetails);
//        productOfferings.setProductOfferingDetails(productOfferingDetails);
//        return productOfferings;
//    }
    @Transactional
@Override
public ProductOfferings assignProductDetail(AssignProductDetailReq request) {
    List<Long> productDetailIds = new LinkedList<>(new HashSet<>(request.getProductDetailIds()));
    if (request.getProductOfferingId() == null){
        throw new RuntimeException("productOfferingId not null");
    }
    if (productDetailIds == null || productDetailIds.isEmpty()){
        throw new RuntimeException("productDetailIds not null or empty");
    }

    Optional<ProductOfferings> productOfferingsOptional = productOfferingRepo.findById(request.getProductOfferingId());
    if (productOfferingsOptional.isEmpty()){
        throw new RuntimeException("productOfferingId not found");
    }
    ProductOfferings productOfferings = productOfferingsOptional.get();
    List<ProductDetail> productDetails = productDetailRepo.findAllById(productDetailIds);
    if(productDetails.isEmpty()){
        throw new RuntimeException("productDetailIds not found");
    }

    productOfferingDetailRepo.deleteByProductOfferings(productOfferings);
    List<ProductOfferingDetail> productOfferingDetails = new ArrayList<>();
    for (int i = 0; i < productDetailIds.size(); i++) {
//        Optional<ProductOfferingDetail> productOfferingDetailOptional = productOfferingDetailRepo.findByProductOfferingsAndProductDetail(productOfferings, productDetails.get(i));
//        if (productOfferingDetailOptional.isPresent()){
//            continue;
//        }

        ProductOfferingDetail productOfferingDetail = new ProductOfferingDetail();
        productOfferingDetail.setProductOfferings(productOfferings);
        productOfferingDetail.setProductDetail(productDetails.get(i));
        productOfferingDetails.add(productOfferingDetail);
    }

//    productOfferingDetailRepo.saveAll(productOfferingDetails);
//    productOfferings.setProductOfferingDetails(productOfferingDetails);
    return productOfferings;
}
}
