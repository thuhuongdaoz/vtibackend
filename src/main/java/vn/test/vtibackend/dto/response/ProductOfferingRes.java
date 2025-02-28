package vn.test.vtibackend.dto.response;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ProductOfferingRes implements Serializable {
    private Long id;

    private String name;

    private Long price;

    private String color;

    private String status;
}
