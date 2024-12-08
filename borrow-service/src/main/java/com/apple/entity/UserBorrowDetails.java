package com.apple.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@AllArgsConstructor
@Data
public class UserBorrowDetails {
    User user;
    List<Book> books;
}
