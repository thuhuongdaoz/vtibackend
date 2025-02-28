package vn.test.vtibackend.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GroupReq implements Serializable {
    @NotBlank(message = "group name không được để trống")
    @Length(min = 3, message = "group name phai co it nhat 3 ky tu")
    private String name;

}
