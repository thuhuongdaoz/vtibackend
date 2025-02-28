package vn.test.vtibackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "product_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProductDetail implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "weight")
    private Integer weight;
    @Column(name = "feature")
    private String feature;
    @Column(name = "power")
    private String power;
    @Column(name = "brand")
    private String brand;
    @Column(name = "image")
    private String image;
    @Column(name = "video")
    private String video;

//    @OneToOne(mappedBy = "productDetail")
//    private ProductOfferings productOfferings;
//    @OneToMany(mappedBy = "productDetail")
//    private List<ProductOfferings> productOfferings;

    @OneToMany(mappedBy = "productDetail")
    @JsonIgnore
    private List<ProductOfferingDetail> productOfferingDetails;
}
