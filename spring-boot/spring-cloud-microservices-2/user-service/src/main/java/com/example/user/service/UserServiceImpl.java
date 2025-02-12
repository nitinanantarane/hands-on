package com.example.user.service;

import com.example.user.repository.UserRepository;
import com.example.user.entity.SimpleUser;
import com.example.user.vo.Department;
import com.example.user.vo.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<SimpleUser> get() {
        return userRepository.findAll();
    }

    @Override
    public SimpleUser save ( SimpleUser simpleUser) {
        log.info("saving new user");
        final SimpleUser savedSimpleUser = userRepository.save ( simpleUser );
        return savedSimpleUser;
    }

    @Override
    public SimpleUser get (Long id) {
        log.info ("Returning user {}", id);
        return userRepository.findById(id).get ();
    }

    @Override
    public SimpleUser update (Long id, SimpleUser simpleUser) {
        log.info("updating user {}", id);
        final SimpleUser savedSimpleUser = userRepository.findById(id).get();
        savedSimpleUser.setDepartmentId (simpleUser.getDepartmentId());
        savedSimpleUser.setFirstName(simpleUser.getFirstName());
        savedSimpleUser.setLastName(simpleUser.getLastName());
        return userRepository.save (savedSimpleUser);
    }

    @Override
    public void delete (Long id) {
        userRepository.deleteById (id);
    }

    @Override
    public ResponseVO getUserAndDepartment(Long userId) {
        log.info("Returning user and department {}", userId);
        final SimpleUser simpleUser = userRepository.findById(userId).get();
        final Department department = restTemplate.getForObject(
                "http://DEPARTMENT-SERVICE/department/" + simpleUser.getDepartmentId(),
                Department.class);

        return new ResponseVO(simpleUser, department);
    }
}
