package com.cjt.service;

import com.cjt.pojo.User;

public interface UserService {

    /**
     * 查找一个用户
     */
    public User findUser(String uId);

    /**
     * 插入信息并返回主键
     */
    public int insertUser(User user);
}
