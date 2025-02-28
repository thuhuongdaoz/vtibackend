package vn.test.vtibackend.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.test.vtibackend.dto.request.UserDTO;

@RestController
@RequestMapping("api/v1/users")
@Validated
public class UserController {


//    @PostMapping
//    public String createUser(@RequestBody @Valid UserDTO userDTO) {
//        return "hello";
//    }

}
