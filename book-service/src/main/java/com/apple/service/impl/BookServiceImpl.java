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
}
