package vn.test.vtibackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.test.vtibackend.dto.request.ProductDetailCreateReq;
import vn.test.vtibackend.entity.ProductDetail;
import vn.test.vtibackend.repository.ProductDetailRepo;
import vn.test.vtibackend.service.ProductDetailService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductDetailServiceImpl implements ProductDetailService {

    private final ProductDetailRepo productDetailRepo;
    @Override
    public List<ProductDetail> getAll() {
        return productDetailRepo.findAll();
    }

    @Override
    public ProductDetail create(ProductDetailCreateReq request) {
        if (request.getWeight() == null || request.getWeight() <= 0 || request.getFeature() == null) {
            throw new RuntimeException("chua dien du thong tin");
        }
        ProductDetail productDetail = new ProductDetail();
        productDetail.setWeight(request.getWeight());
        productDetail.setFeature(request.getFeature());
        productDetail.setPower(request.getPower());
        productDetail.setBrand(request.getBrand());
        productDetail.setImage(request.getImage());
        productDetail.setVideo(request.getVideo());

        return productDetailRepo.save(productDetail);
    }
}
