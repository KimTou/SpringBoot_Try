package com.cjt.mapper;

import com.cjt.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    /**
     * 通过姓名查找一个用户
     */
    @Select("select * from user where username=#{userName}")
    public User findUserByUserName(String userName);

    /**
     * 通过学号查找一个用户
     */
    @Select("select * from user where u_id=#{uid}")
    public User findUserByUId(String uId);

    /**
     * 插入信息并返回主键
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into user (userName,u_id,major,resume,result) values(#{userName},#{uId},#{major},#{resume},#{result})")
    public int insertUser(User user);

    /**
     * 修改信息
     */
    @Update("update user set userName=#{userName},major=#{major},resume=#{resume} where u_id=#{uId}")
    public int updateUser(User user);

    /**
     * 删除用户
     */
    @Delete("delete from user where id=#{id}")
    public int deleteUser(Integer id);
}
