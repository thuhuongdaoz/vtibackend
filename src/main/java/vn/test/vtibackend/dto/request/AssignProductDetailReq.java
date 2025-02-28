package vn.test.vtibackend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssignProductDetailReq implements Serializable {
    private Long productOfferingId;
    private List<Long> productDetailIds;
}
