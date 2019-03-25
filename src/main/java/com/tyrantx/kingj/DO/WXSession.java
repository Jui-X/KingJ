package com.tyrantx.kingj.DO;

import lombok.Data;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-03-25 20:30
 **/
@Data
public class WXSession {

    private String session_key;

    private String openid;
}
