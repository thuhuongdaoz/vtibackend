package vn.test.vtibackend.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import vn.test.vtibackend.common.RoleEnum;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserReq implements Serializable {
    @NotBlank(message = "username không được để trống")
    @Length(min = 3, message = "username phai co it nhat 3 ky tu")
    private String name;


    @Email(message = "email khong dung dinh dang")
    private String email;

    @NotNull(message = "role không được để trống")
    private RoleEnum role;

}
