package com.example.user.controller;

import com.example.user.entity.SimpleUser;
import com.example.user.service.UserService;
import com.example.user.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<SimpleUser> get() {
        return userService.get();
    }

    @GetMapping("/{id}")
    public SimpleUser get(@PathVariable("id") Long id) {
        return userService.get(id);
    }

    @PostMapping
    public SimpleUser save(@RequestBody SimpleUser simpleUser) {
        return userService.save(simpleUser);
    }

    @PutMapping("/{id}")
    public SimpleUser update(@PathVariable("id") Long id,
                             @RequestBody SimpleUser simpleUser) {
        return userService.update(id, simpleUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete( @PathVariable("id") Long id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}/department")
    public ResponseVO getUserAndDepartment(@PathVariable("userId") Long userId) {
        return userService.getUserAndDepartment(userId);
    }

}
