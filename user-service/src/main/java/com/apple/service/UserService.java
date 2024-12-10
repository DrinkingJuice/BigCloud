package com.apple.service;

import com.apple.entity.User;

public interface UserService {
    User getUserById(int uid);
    int getRemain(int uid);
    boolean updateUserBook(int uid, int count);
}
