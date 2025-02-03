package vn.test.vtibackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
//@Table(name = "product_offerings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductOfferings implements Serializable {
    @Id
//    @Column(name = "id")
    private Long id;

//    @Column(name = "name")
    private String name;

//    @Column(name = "price")
    private Long price;

//    @Column(name = "color")
    private String color;
}
