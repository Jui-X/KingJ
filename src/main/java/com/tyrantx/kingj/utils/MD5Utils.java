package com.tyrantx.kingj.utils;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.security.MessageDigest;

/**
 * @param: none
 * @description: 对字符串进行md5加密
 * @author: KingJ
 * @create: 2019-02-08 23:31
 **/
@Component
public class MD5Utils implements TokenGenerator{

    public static String getMD5Str(String strValue) throws Exception {

        MessageDigest md5 = MessageDigest.getInstance("MD5");
        String newStr = Base64.encodeBase64String(md5.digest(strValue.getBytes()));
        return newStr;
    }

    @Override
    public String tokenGenerate(String... strings) {
        long timestamp = System.currentTimeMillis();
        String tokenMeta = "";
        for (String s: strings) {
            tokenMeta += s;
        }
        tokenMeta = tokenMeta + timestamp;
        String token = DigestUtils.md5DigestAsHex(tokenMeta.getBytes());
        return token;
    }
}
