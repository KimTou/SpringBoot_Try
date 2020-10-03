package com.cjt.service.impl;

import com.cjt.mapper.UserMapper;
import com.cjt.pojo.User;
import com.cjt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUser(String uId) {
        return userMapper.findUser(uId);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }
}
