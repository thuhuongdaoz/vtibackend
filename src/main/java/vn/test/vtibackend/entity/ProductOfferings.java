package vn.test.vtibackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.test.vtibackend.common.StatusEnum;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "product_offerings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductOfferings implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "price")
    private Long price;

    @Column(name = "color")
    private String color;

    @Column(name = "status")
//    @Enumerated(EnumType.STRING)
//    private StatusEnum status;
    private String status;

//    @OneToOne(fetch = FetchType.LAZY)
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "detail_id", referencedColumnName = "id")
//    @JsonIgnore
//    private ProductDetail productDetail;
    @OneToMany(mappedBy = "productOfferings")
    private List<ProductOfferingDetail> productOfferingDetails;

    @Override
    public String toString() {
        return "ProductOfferings{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
