package vn.test.vtibackend.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailCreateReq implements Serializable {
    private Integer weight;
    private String feature;
    private String power;
    private String brand;
    private String image;
    private String video;
}
