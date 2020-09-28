package com.cjt.mapper;

import com.cjt.domain.User;
import org.apache.ibatis.annotations.*;

/**
 * @author cjt
 */
//@Mapper
public interface UserMapper {

    /**
     * 查找一个用户
     * @param uId
     * @return
     */
    @Select("select * from user where u_id=#{uid}")
    public User findUser(String uId);

    /**
     * 插入信息并返回主键
     * @param user
     */
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into user (userName,u_id,major,resume) values(#{userName},#{uId},#{major},#{resume})")
    public int insertUser(User user);

    /**
     * 修改信息
     * @param user
     */
    @Update("update user set userName=#{userName},u_id=#{uId} where id=#{id}")
    public int updateUser(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    @Delete("delete from user where id=#{id}")
    public int deleteUser(Integer id);
}
