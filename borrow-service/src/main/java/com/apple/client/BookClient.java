package com.apple.client;

import com.apple.entity.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("book-service")
public interface BookClient {

    @RequestMapping("/book/{bid}")
    Book getBook(@PathVariable("bid") int bid);
}
