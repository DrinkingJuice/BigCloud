package com.apple.service;

import com.apple.entity.Borrow;
import com.apple.entity.UserBorrowDetails;

public interface BorrowService {
    UserBorrowDetails getUserBorrowDetails(int uid);
    boolean doBorrow(int uid, int bid);
}
