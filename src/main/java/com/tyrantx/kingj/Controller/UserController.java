package com.tyrantx.kingj.Controller;

import com.tyrantx.kingj.Constant.RedisConstant;
import com.tyrantx.kingj.Pojo.User;
import com.tyrantx.kingj.Service.UserService;
import com.tyrantx.kingj.Utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private MD5Utils tokenGenerator;

    @ApiOperation(value = "查询所有用户信息", notes = "查询所有用户信息的接口")
    @PostMapping("/allUsers")
    public List<User> queryAllUsers() {
        return userService.queryAllUers();
    }

    @PostMapping("/login")
    public void createUser(@RequestBody(required = true)JSONObject userInfo) {
        String username = userInfo.getString("username");
        String password = userInfo.getString("password");

        User currentUser = userService.queryUserByName(username);
        if(currentUser == null) {
            String token = tokenGenerator.tokenGenerate(username, password);
            redisTemplate.opsForValue().set(username, token, RedisConstant.EXPIRE_TIME, TimeUnit.SECONDS);
            redisTemplate.opsForValue().set(token, username, RedisConstant.EXPIRE_TIME, TimeUnit.SECONDS);
            Long currentTime = System.currentTimeMillis();
            redisTemplate.opsForValue().set(String.format(username, token), currentTime.toString());
        }

    }
}
