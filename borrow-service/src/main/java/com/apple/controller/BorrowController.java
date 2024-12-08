package com.apple.controller;

import com.apple.entity.Borrow;
import com.apple.entity.UserBorrowDetails;
import com.apple.service.BorrowService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BorrowController {

    @Resource
    private BorrowService borrowService;

    @RequestMapping("/borrow/{uid}")
    public UserBorrowDetails borrow(@PathVariable int uid) {
        return borrowService.getUserBorrowDetails(uid);
    }
}
