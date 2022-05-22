package com.hyh.service.impl;

import com.hyh.dao.UserDao;
import com.hyh.pojo.User;
import com.hyh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author 潮7000
 * @vesion 1.0
 * @date 2022/5/13 23:30
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
    /**
     *
     */
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User selectByUsername(String username) {

        return userDao.selectByUsername(username);
    }
    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }
}
