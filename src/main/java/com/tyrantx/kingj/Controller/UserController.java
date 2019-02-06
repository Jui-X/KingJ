package com.tyrantx.kingj.Controller;

import com.tyrantx.kingj.Pojo.User;
import com.tyrantx.kingj.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/allUsers")
    public List<User> queryAllUsers() {
        return userService.queryAllUers();
    }
}
