package com.apple.mapper;

import com.apple.entity.Borrow;
import com.apple.entity.UserBorrowDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BorrowMapper {
    @Select("select * from DB_BRROW where uid = #{uid}")
    List<Borrow> getBorrowByUid(int uid);
}
