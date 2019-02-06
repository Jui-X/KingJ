package com.tyrantx.kingj.Mapper;

import com.tyrantx.kingj.Pojo.User;
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
}


