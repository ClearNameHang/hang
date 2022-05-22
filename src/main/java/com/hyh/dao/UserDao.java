package com.hyh.dao;

import com.hyh.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @author 潮7000
 * @vesion 1.0
 * @date 2022/5/13 23:06
 */
public interface UserDao {

    @Insert("insert into user values(#{id},#{username},#{password},#{email},#{name},#{telephone},#{sex},#{birthday})")
     int insertUser(User user);

    @Select("select * from user where username = #{username}")
     User selectByUsername(String username);


}
