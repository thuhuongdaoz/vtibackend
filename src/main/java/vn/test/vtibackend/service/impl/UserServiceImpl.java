package vn.test.vtibackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import vn.test.vtibackend.dto.request.GroupReq;
import vn.test.vtibackend.dto.request.UserReq;
import vn.test.vtibackend.entity.Group;
import vn.test.vtibackend.entity.User;
import vn.test.vtibackend.repository.GroupRepository;
import vn.test.vtibackend.repository.UserRepository;
import vn.test.vtibackend.service.GroupService;
import vn.test.vtibackend.service.UserService;
import vn.test.vtibackend.service.spec.GroupSpecification;
import vn.test.vtibackend.service.spec.UserSpecification;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<User> search(String keyword) {
        Specification<User> specification = Specification.where(UserSpecification.likeName(keyword))
                .or(UserSpecification.likeEmail(keyword))
                .or(UserSpecification.equalRole(keyword));
        return userRepository.findAll(specification);
    }

    @Override
    public User create(UserReq request) {
        User user = modelMapper.map(request, User.class);
        return userRepository.save(user);
    }

    @Override
    public User update(Integer id, UserReq request) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("khong tim thay user"));
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setRole(request.getRole());
        return userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}
