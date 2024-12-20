package com.apple.controller;

import com.apple.entity.User;
import com.apple.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @Value("${test.hello}")
    private String hello;

    @RequestMapping("/user/{uid}") //RestFul风格
    public User getUser(@PathVariable int uid) {
        System.out.println("我被调用了！");
        System.out.println("hello" + " " + hello);
        return userService.getUserById(uid);
    }

    @RequestMapping("/user/remain/{uid}")
    public int getUserRemain(@PathVariable int uid) {
        return userService.getRemain(uid);
    }

    @RequestMapping ("/user/borrow/{uid}")
    public boolean borrowBook(@PathVariable int uid) {
        int remain = userService.getRemain(uid);
        if (remain > 0) {
            return userService.updateUserBook(uid, remain - 1);
        }
        return false;
    }
}
