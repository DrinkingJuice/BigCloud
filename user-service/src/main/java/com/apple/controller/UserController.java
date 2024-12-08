package com.apple.controller;

import com.apple.entity.User;
import com.apple.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/user/{uid}") //RestFul风格
    public User getUser(@PathVariable int uid) {
        System.out.println("我被调用了！");
        return userService.getUserById(uid);
    }
}
