package com.apple.service;

import com.apple.entity.Book;

public interface BookService {
    Book getBookById(int id);

    boolean setRemain(int bid, int count);

    int getRemain(int bid);
}
