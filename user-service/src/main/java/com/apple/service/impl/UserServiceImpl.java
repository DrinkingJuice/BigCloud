package com.apple.service.impl;

import com.apple.entity.User;
import com.apple.mapper.UserMapper;
import com.apple.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public User getUserById(int uid) {
        return userMapper.getUserById(uid);
    }
}
