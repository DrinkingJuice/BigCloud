package com.apple.service.Impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.apple.client.BookClient;
import com.apple.client.UserClient;
import com.apple.entity.Book;
import com.apple.entity.Borrow;
import com.apple.entity.User;
import com.apple.entity.UserBorrowDetails;
import com.apple.mapper.BorrowMapper;
import com.apple.service.BorrowService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Resource
    BorrowMapper borrowMapper;

    @Resource
    UserClient userClient;

    @Resource
    BookClient bookClient;

    @SentinelResource(value = "borrowDetails", blockHandler = "getUserBorrowDetailsFail") //方法级别的限流处理，粒度更细
    @Override
    public UserBorrowDetails getUserBorrowDetails(int uid) {
        List<Borrow> borrowList = borrowMapper.getBorrowByUid(uid);
        //需要根据uid和bid去查询具体的书籍信息和用户信息
        //这里使用RestTemplate远程调用
//        //RestTemplate restTemplate = new RestTemplate();
//        User user = restTemplate.getForObject("http://localhost:8101/user/"+uid, User.class);
//        //这里使用stream流来查询书籍信息
//        List<Book> books = borrowList.stream().map(borrow ->
//                        restTemplate.getForObject("http://localhost:8301/book/" + borrow.getBid(), Book.class)).toList();
//        return new UserBorrowDetails(user, books);

        //使用新的nacos服务注册发现去互调服务
        User user = userClient.getUser(uid);
        //同样的使用stream流
        List<Book> books = borrowList.stream().map(borrow -> bookClient.getBook(borrow.getBid())).toList();
        return new UserBorrowDetails(user, books);
    }

    //限流后的处理方法
    public UserBorrowDetails getUserBorrowDetailsFail(int uid, BlockException e) {
        return new UserBorrowDetails(null, Collections.emptyList());
    }
}
