package com.example.user.service;

import com.example.user.entity.SimpleUser;
import com.example.user.vo.ResponseVO;

import java.util.List;

public interface UserService {
    List<SimpleUser> get();
    SimpleUser save (SimpleUser simpleUser);
    SimpleUser get (Long id);
    SimpleUser update (Long id, SimpleUser simpleUser);
    void delete (Long id);
    ResponseVO getUserAndDepartment (Long userId);
}
