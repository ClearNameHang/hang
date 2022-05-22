package com.hyh.service;

import com.hyh.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author 潮7000
 * @vesion 1.0
 * @date 2022/5/14 14:35
 */
public interface UserService {
    User selectByUsername(String username);

    int insertUser(User user);
}
