package com.tyrantx.kingj.Service.ServiceImpl;

import com.tyrantx.kingj.Mapper.UserMapper;
import com.tyrantx.kingj.Pojo.User;
import com.tyrantx.kingj.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-02-06 22:31
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     *
     * @Transactional: 事务注解
     *                  REQUIRED: 当操作被执行时，有事务则将事务加入到当前事务中，没有则另起一个新的事物去执行
     *                  SUPPORTS: 当操作被执行时，有事务则将事务加入到当前事务中，没有则脱离事务执行
     *                  REQUIRED: 常用于增加、删除、修改等操作
     *                  SUPPORTS: 常用于读取操作
     *
     **/
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> queryAllUers() {
        return userMapper.queryAllUsers();
    }
}
