package vn.test.vtibackend.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import vn.test.vtibackend.common.GenderEnum;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {


    @NotEmpty(message = "username khong duoc de trong")
    @Length(min = 3, max = 20)
    @Pattern(regexp = "[a-zA-Z0-9]+") //
    private String username;

    @NotEmpty
    @Length(min = 6)
    //
    private String password;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    @Length(max = 255)
    private String fullName;

//    @Pattern()

    private String phoneNumber;

    @FutureOrPresent
    //
    private Date dateOfBirth;

    @NotEmpty
    private String street;
    @NotEmpty
    private String city;
    @NotEmpty
    private String state;
//    @Pattern()
    private String zipCode;

    @AssertTrue
    private boolean agreeToTerms;

    //
    private GenderEnum gender;

    @NotEmpty//
    private String security;//



}
