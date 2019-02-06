package com.tyrantx.kingj.Pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @param: none
 * @description: 对应数据库user表的pojo
 * @author: KingJ
 * @create: 2019-02-06 21:44
 **/
@Data
public class User {

    /** uid */
    private Integer id;

    /** 用户名 */
    private String name;

    /** 用户密码 */
    private String password;

}
