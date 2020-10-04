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
    public User findUserByUserName(String userName) {
        return userMapper.findUserByUserName(userName);
    }

    @Override
    public User findUserByUId(String uId) {
        return userMapper.findUserByUId(uId);
    }

    @Override
    public int insertUser(User user) {
        String regexUId = "3[12][0-9]{8}";
        //判断学号是否符合格式
        if(!user.getUId().matches(regexUId)){
            return -1;
        }
        user.setResult("请耐心等待呀，我们会尽快公布结果的~");
        return userMapper.insertUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }
}
