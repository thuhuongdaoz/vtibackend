package vn.test.vtibackend.service;


import vn.test.vtibackend.dto.request.GroupReq;
import vn.test.vtibackend.entity.Group;

import java.util.List;

public interface GroupService {
    List<Group> search(String name);
    Group create(GroupReq request);
    Group update(Integer id, GroupReq request);
    void delete(Integer id);


}
