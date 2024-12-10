package com.apple.client;

import com.apple.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserClientImpl implements UserClient {

    @Override
    public User getUser(int uid) {
        User user = new User();
        user.setName("我是替代client");
        return user;
    }

    @Override
    public boolean userBorrow(int uid) {
        return false;
    }

    @Override
    public int userRemain(int uid) {
        return 0;
    }
}
