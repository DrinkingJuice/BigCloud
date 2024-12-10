package com.apple.service.impl;

import com.apple.Mapper.BookMapper;
import com.apple.entity.Book;
import com.apple.service.BookService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    BookMapper bookMapper;

    @Override
    public Book getBookById(int id) {
        return bookMapper.getBookById(id);
    }

    @Override
    public boolean setRemain(int bid, int count) {
        return bookMapper.setRemain(bid, count) > 0;
    }

    @Override
    public int getRemain(int bid) {
        return bookMapper.getRemain(bid);
    }
}
