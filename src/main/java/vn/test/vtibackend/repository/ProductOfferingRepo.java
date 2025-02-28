package vn.test.vtibackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import vn.test.vtibackend.entity.ProductOfferings;

import java.util.List;

public interface ProductOfferingRepo extends JpaRepository<ProductOfferings, Long>, JpaSpecificationExecutor<ProductOfferings> {
    @Query("select po from ProductOfferings po where po.name = 'Product_11'")
    List<ProductOfferings> findByName(String name);

    List<ProductOfferings> findByNameAndPrice(String name, Long price);
    @Query("select po\n" +
            "from ProductOfferings po\n" +
            "where po.id in (select distinct pod.productOfferings.id\n" +
            "from ProductOfferingDetail pod\n" +
            "join ProductDetail pd with pd.brand = 'samsung'\n" +
            " where pod.productDetail.id = pd.id)")

//    @Query("select po\n" +
//            "from ProductOfferings po\n" +
//            "where po.id in (select distinct pod.productOfferings.id\n" +
//            "             from ProductOfferingDetail pod\n" +
//            "                      join (select pd from ProductDetail pd where pd.brand = 'samsung') pd1\n" +
//            "                           on pod.productDetail.id = pd1.id)")

//    @Query(value = "select *\n" +
//            "from product_offerings\n" +
//            "where id in (select distinct pod.product_offering_id\n" +
//            "             from product_offering_detail pod\n" +
//            "                      join (select pd.* from product_details pd where brand = 'samsung') pd1\n" +
//            "                           on pod.product_detail_id = pd1.id)", nativeQuery = true)
    List<ProductOfferings> findByBrand(String brand);

}
