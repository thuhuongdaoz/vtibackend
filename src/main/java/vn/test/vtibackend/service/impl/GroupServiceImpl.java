package vn.test.vtibackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import vn.test.vtibackend.dto.request.GroupReq;
import vn.test.vtibackend.entity.Group;
import vn.test.vtibackend.repository.GroupRepository;
import vn.test.vtibackend.service.GroupService;
import vn.test.vtibackend.service.spec.GroupSpecification;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;

    @Override
    public List<Group> search(String name) {
        Specification<Group> specification = Specification.where(GroupSpecification.likeName(name));
        return groupRepository.findAll(specification);
    }

    @Override
    public Group create(GroupReq request) {
        Group group = new Group();
        group.setName(request.getName());
        group.setCreator("ADMIN");
        return groupRepository.save(group);
    }

    @Override
    public Group update(Integer id, GroupReq request) {
        Group group = groupRepository.findById(id).orElseThrow(() -> new RuntimeException("khong tim thay group"));
        group.setName(request.getName());
        return groupRepository.save(group);
    }

    @Override
    public void delete(Integer id) {
        groupRepository.deleteById(id);
    }
}
