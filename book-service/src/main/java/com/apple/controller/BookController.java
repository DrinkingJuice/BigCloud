package com.apple.controller;

import com.apple.entity.Book;
import com.apple.service.BookService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Resource
    private BookService bookService;

    @RequestMapping("/book/{bid}")
    public Book getBook(@PathVariable("bid") int bid) {
        System.out.println("我被调用了！");
        return bookService.getBookById(bid);
    }


    @RequestMapping("/book/remain/{bid}")
    public int bookRemain(@PathVariable("bid") int uid) {
        return bookService.getRemain(uid);
    }

    @RequestMapping("/book/borrow/{bid}")
    public boolean bookBorrow(@PathVariable("bid") int uid) {
        int remain = bookService.getRemain(uid);
        if (remain > 0) {
            return bookService.setRemain(uid, remain - 1);
        }
        return false;
    }
}
