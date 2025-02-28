package vn.test.vtibackend.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import vn.test.vtibackend.common.StatusEnum;
import vn.test.vtibackend.dto.request.ProductOfferingCreateReq;
import vn.test.vtibackend.entity.ProductOfferings;
import vn.test.vtibackend.repository.ProductOfferingRepo;
import vn.test.vtibackend.service.ProductOfferingService;
import vn.test.vtibackend.service.spec.ProductOfferingSpecifications;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductOfferingServiceImpl implements ProductOfferingService {

    private final EntityManager entityManager;

    private final ProductOfferingRepo productOfferingRepo;
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

    @Override
    public List<ProductOfferings> searchByName(String name) {
        return productOfferingRepo.findByName(name);
    }

    @Override
    public List<ProductOfferings> searchByNameAndPrice(String name, Long price) {
        return productOfferingRepo.findByNameAndPrice(name, price);
    }

//    @Override
//    public ProductOfferings createProduct(ProductOfferings productOfferings) {
//        if(productOfferings.getId() != null){
//            throw new RuntimeException("khong duoc phep truyen id vao");
//        }
//        return productOfferingRepo.save(productOfferings);
//    }
@Override
public ProductOfferings create(ProductOfferingCreateReq request) {
    if (request.getName() == null || request.getName().trim().isEmpty() || request.getPrice() == null || request.getColor() == null){
        throw new RuntimeException("chua dien du thong tin");
    }
    ProductOfferings productOffering = new ProductOfferings();
    productOffering.setName(request.getName());
    productOffering.setPrice(request.getPrice());
    productOffering.setColor(request.getColor());
    productOffering.setStatus("ACTIVE");
    return productOfferingRepo.save(productOffering);
}

    @Override
    public ProductOfferings updateProduct(Long id, ProductOfferings productOfferings) {
        ProductOfferings product = productOfferingRepo.findById(id).orElseThrow(() -> new RuntimeException("khong tim thay product"));
        if (product == null){
            throw new RuntimeException("khong tim thay product");
        }
        return productOfferingRepo.save(productOfferings);
    }

    @Override
    public List<ProductOfferings> searchByBrand(String brand) {
        return productOfferingRepo.findByBrand(brand);
//        return List.of();
    }
    @Override
    public List<ProductOfferings> filter(String name, Long minPrice, Long maxPrice, String color, String status) {
        Specification<ProductOfferings> specification = Specification.where(ProductOfferingSpecifications.likeName(name))
                .and(ProductOfferingSpecifications.minPrice(minPrice))
                .and(ProductOfferingSpecifications.maxPrice(maxPrice))
                .and(ProductOfferingSpecifications.likeColor(color))
                .and(ProductOfferingSpecifications.equalStatus(status));

//        if (name != null && !name.isEmpty()){
//            specification = specification.and(ProductOfferingSpecifications.likeName(name));
//        }
//        if (minPrice != null){
//            specification = specification.and(ProductOfferingSpecifications.minPrice(minPrice));
//        }

        return productOfferingRepo.findAll(specification);


    }

//    @Override
//    public List<ProductOfferings> filter(String name, Long minPrice, Long maxPrice, String color, String status) {
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<ProductOfferings> query = criteriaBuilder.createQuery(ProductOfferings.class);
//
//        Root<ProductOfferings> root = query.from(ProductOfferings.class);
//        List<Predicate> predicates = new ArrayList<>();
//        if (name != null && !name.isEmpty()){
//            Predicate predicate = criteriaBuilder.like(root.get("name"), "%" + name + "%");
//            predicates.add(predicate);
//        }
//
//        if (minPrice != null){
//            Predicate predicate = criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
//            predicates.add(predicate);
//        }
//
//        if (maxPrice != null){
//            Predicate predicate = criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
//            predicates.add(predicate);
//        }
//
//        if (color != null && !color.isEmpty()){
//            Predicate predicate = criteriaBuilder.like(root.get("color"), "%" + color + "%");
//            predicates.add(predicate);
//        }
//        if (status != null && !status.isEmpty()){
//            Predicate predicate = criteriaBuilder.equal(root.get("status"), status);
//            predicates.add(predicate);
//        }
//
//        query.where(predicates.toArray(new Predicate[0]));
//
//        return entityManager.createQuery(query).getResultList();
//
//
//    }
}
