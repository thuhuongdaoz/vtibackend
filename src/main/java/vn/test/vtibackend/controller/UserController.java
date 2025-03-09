package vn.test.vtibackend.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.test.vtibackend.dto.request.UserReq;
import vn.test.vtibackend.entity.User;
import vn.test.vtibackend.service.UserService;


import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> search(@RequestParam(required = false) String keyword) {
        List<User> users = userService.search(keyword);
        return ResponseEntity.ok(users);
    }
    @PostMapping
    public ResponseEntity<User> create(@RequestBody @Valid UserReq request){
        User user = userService.create(request);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody @Valid UserReq request){
        User user = userService.update(id, request);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        userService.delete(id);
    }

}
