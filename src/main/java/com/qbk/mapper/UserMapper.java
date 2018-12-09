package com.qbk.mapper;

import com.qbk.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: quboka
 * @Date: 2018/12/9 17:23
 * @Description:
 */
@Mapper
public interface UserMapper {

//    @Select("SELECT id,username,`password` FROM t_user WHERE username = #{username}")
    User findByUsername(@Param("username") String username) ;

    List<User> findAll();

    int insert(User userToAdd);
}
