package com.cjt.service;

import com.cjt.pojo.User;

public interface UserService {

    /**
     * 通过姓名查找一个用户
     */
    public User findUserByUserName(String userName);

    /**
     * 通过学号查找一个用户
     */
    public User findUserByUId(String uId);

    /**
     * 插入信息并返回主键
     */
    public int insertUser(User user);

    /**
     * 修改信息
     */
    public int updateUser(User user);
}
