package com.apple.client;

import com.apple.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("user-service")
public interface UserClient {

    @RequestMapping("/user/{uid}")
    User getUser(@PathVariable("uid") int uid);
}
