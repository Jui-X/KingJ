package com.tyrantx.kingj.Utils;

import org.apache.tomcat.util.codec.binary.Base64;

import java.security.MessageDigest;

/**
 * @param: none
 * @description: 对字符串进行md5加密
 * @author: KingJ
 * @create: 2019-02-08 23:31
 **/
public class MD5Utils {

    public static String getMD5Str(String strValue) throws Exception {

        MessageDigest md5 = MessageDigest.getInstance("MD5");
        String newStr = Base64.encodeBase64String(md5.digest(strValue.getBytes()));
        return newStr;
    }

    public static void main(String[] args) {

    }
}
