package cn.edu.njupt.mapper;

import cn.edu.njupt.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper

public interface UserMapper {

    @Select("select name from user where userCode = #{userCode} and password = #{password}")
    User SelectByUserCodeAndPassword(User user);
}
