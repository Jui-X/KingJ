package com.tyrantx.kingj.Controller;

import com.tyrantx.kingj.Pojo.User;
import com.tyrantx.kingj.Service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-02-06 22:31
 **/
@RestController
@Api(value = "用户接口", tags = "用户的Controller")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询所有用户信息", notes = "查询所有用户信息的接口")
    @PostMapping("/allUsers")
    public List<User> queryAllUsers() {
        return userService.queryAllUers();
    }
}
