package com.tyrantx.kingj.controller;

import com.alibaba.fastjson.JSONObject;
import com.tyrantx.kingj.constant.RedisConstant;
import com.tyrantx.kingj.domain.WXSession;
import com.tyrantx.kingj.utils.HttpClient;
import com.tyrantx.kingj.common.JsonResult;
import com.tyrantx.kingj.utils.JsonUtils;
import com.tyrantx.kingj.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @param: none
 * @description: 获取小程序后端的open_id和session_key作为key-value存入Redis
 * @author: KingJ
 * @create: 2019-03-25 20:27
 **/
@RestController
public class WXLoginController {

    @Autowired
    private RedisOperator redis;

    @PostMapping("/wxLogin")
    public JsonResult wxLogin(@RequestBody(required = true)JSONObject codeJson) {
        String code = codeJson.getString("code");
//        System.out.println(code);

        /**
         *
         * https://api.weixin.qq.com/sns/jscode2session?
         * 				appid=APPID&
         * 				secret=SECRET&
         * 				js_code=JSCODE&
         * 				grant_type=authorization_code
         *
         **/


        String url =  "https://api.weixin.qq.com/sns/jscode2session";
        Map<String, String> param = new HashMap<>();
        param.put("appid", "wxcd637a1e509ee41c");
        param.put("secret", "c084251a0297f033762a4438b8eb6a97");
        param.put("js_code", code);
        param.put("grant_type", "authorization_code");

        String wxResult = HttpClient.doGet(url, param);
        System.out.println(wxResult);

        WXSession session = JsonUtils.jsonToPojo(wxResult, WXSession.class);

        redis.set("user-redis-session" + session.getOpenid(),
                session.getSession_key(),
                RedisConstant.EXPIRE_TIME);

        Map<String, String> result = new HashMap<>();
        result.put("code", code);

        return JsonResult.ok(result);
    }
}
