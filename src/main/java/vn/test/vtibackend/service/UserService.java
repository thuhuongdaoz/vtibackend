package vn.test.vtibackend.service;


import vn.test.vtibackend.dto.request.UserReq;
import vn.test.vtibackend.entity.User;

import java.util.List;

public interface UserService {
    List<User> search(String keyword);
    User create(UserReq request);
    User update(Integer id, UserReq request);
    void delete(Integer id);


}
