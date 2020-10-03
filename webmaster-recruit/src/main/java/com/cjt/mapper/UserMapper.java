package com.cjt.mapper;

import com.cjt.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    /**
     * 查找一个用户
     */
    @Select("select * from user where u_id=#{uid}")
    public User findUser(String uId);

    /**
     * 插入信息并返回主键
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into user (userName,u_id,major,resume) values(#{userName},#{uId},#{major},#{resume})")
    public int insertUser(User user);

    /**
     * 修改信息
     */
    @Update("update user set userName=#{userName},u_id=#{uId} where id=#{id}")
    public int updateUser(User user);

    /**
     * 删除用户
     */
    @Delete("delete from user where id=#{id}")
    public int deleteUser(Integer id);
}
