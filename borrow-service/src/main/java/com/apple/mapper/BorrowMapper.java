package com.apple.mapper;

import com.apple.entity.Borrow;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BorrowMapper {
    @Select("select * from DB_BRROW where uid = #{uid}")
    List<Borrow> getBorrowByUid(int uid);

    @Select("select * from DB_BRROW where bid = #{bid} and uid = #{uid}")
    Borrow getBorrow(int uid, int bid);

    @Insert("insert into DB_BRROW(uid,bid) values(#{uid}, #{bid})")
    int addBorrow(int uid, int bid);
}
