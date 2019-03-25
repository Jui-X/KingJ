package com.tyrantx.kingj.DAO;

import com.tyrantx.kingj.DO.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * @param: none
 * @description: User类对应的Mapper类，用于对user表进行CRUD等操作
 * @author: KingJ
 * @create: 2019-02-06 22:14
 **/
public interface UserMapper {

    @Select("SELECT name from user")
    List<User> queryAllUsers();

    @Select("SELECT id FROM user WHERE username = #{username}")
    User queryUserByName(@Param("username")String username);

    @Insert("INSERT INTO user(name, password) VALUES(#{name}, #{password})")
    void createUser(@Param("username")String username, @Param("password")String password);
}


