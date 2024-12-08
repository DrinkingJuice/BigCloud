package com.apple.mapper;

import com.apple.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper {

    @Select("select * from DB_USER where uid = #{uid}")
    User getUserById(int uid);
}
