package com.tyrantx.kingj.Controller;

import com.tyrantx.kingj.Pojo.User;
import com.tyrantx.kingj.Utils.JsonResult;
import com.tyrantx.kingj.Utils.JsonUtils;
import com.tyrantx.kingj.Utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @param: none
 * @description: Redis控制类
 * @author: KingJ
 * @create: 2019-02-07 22:32
 **/
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedis;

    @Autowired
    private RedisOperator redis;

    @RequestMapping("/test")
    public JsonResult test() {
        stringRedis.opsForValue().set("test", "test");

        User user = new User();
        user.setId(1001);
        user.setName("KingJ");
        user.setPassword("123456");

        stringRedis.opsForValue().set("json:user", JsonUtils.objectToJson(user));

        User jsonUser = JsonUtils.jsonToPojo(stringRedis.opsForValue().get("json:user"), User.class);

//        return JsonResult.ok(stringRedis.opsForValue().get("test"));
        return JsonResult.ok(jsonUser);
    }

    @RequestMapping("/jsonList")
    public JsonResult getJsonList() {

        User usera = new User();
        usera.setId(1002);
        usera.setName("JuiX");
        usera.setPassword("123456");

        User userb = new User();
        userb.setId(1002);
        userb.setName("TyrantX");
        userb.setPassword("123456");

        List<User> userList = new ArrayList<>();
        userList.add(usera);
        userList.add(userb);

        redis.set("json:info:userList", JsonUtils.objectToJson(userList), 2000);

        String usrListJson = redis.get("json:info:userList");
        List<User> usrList = JsonUtils.jsonToList(usrListJson, User.class);

        return JsonResult.ok(usrList);
    }



}
