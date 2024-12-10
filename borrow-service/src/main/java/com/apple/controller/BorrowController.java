package com.apple.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSONObject;
import com.apple.entity.UserBorrowDetails;
import com.apple.service.BorrowService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class BorrowController {

    @Resource
    private BorrowService borrowService;

    @RequestMapping("/borrow/{uid}")
    public UserBorrowDetails borrow(@PathVariable int uid) {
        return borrowService.getUserBorrowDetails(uid);
    }

    @RequestMapping("/borrow2/{uid}")
    public UserBorrowDetails borrow2(@PathVariable int uid) {
        return borrowService.getUserBorrowDetails(uid);
    }

    @RequestMapping("/blocked")
    public JSONObject blocked() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 403);
        jsonObject.put("success", false);
        jsonObject.put("message", "您的请求速度过快，请稍后再试");
        return jsonObject;
    }

    @RequestMapping("/test")
    @SentinelResource(value = "test",
                fallback = "except",
                exceptionsToIgnore = IOException.class)
    public String test() { //出现所有异常去调用别的方法
        throw new RuntimeException("hello Juice");
    }

    private String except(Throwable t){
        return t.getMessage();
    }

    @RequestMapping("/test2")
    @SentinelResource("/test2")
    public String test2(@RequestParam(value = "a", required = false) String a,
                        @RequestParam(value = "b", required = false) String b,
                        @RequestParam(value = "c", required = false) String c) {
        return "请求成功" + a + "," + b + "," + c;
    }

    @RequestMapping("/borrow/take/{uid}/{bid}")
    JSONObject borrow(@PathVariable("uid") int uid,
                      @PathVariable("bid") int bid){
        borrowService.doBorrow(uid, bid);
        JSONObject object = new JSONObject();
        object.put("code", "200");
        object.put("success", false);
        object.put("message", "借阅成功！");
        return object;
    }
}
