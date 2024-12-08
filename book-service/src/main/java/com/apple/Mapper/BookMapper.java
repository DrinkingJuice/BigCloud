package com.apple.Mapper;

import com.apple.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookMapper {
    @Select("select * from DB_BOOK where bid = #{bid}")
    public Book getBookById(int bid);
}
