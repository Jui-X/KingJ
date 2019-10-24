package com.tyrantx.kingj.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @param: none
 * @description: 对应数据库user表的pojo
 * @author: KingJ
 * @create: 2019-02-06 21:44
 **/
@Data
@ApiModel(value = "用户对象", description = "这是用户对象")
public class User {

    @ApiModelProperty(hidden = true)
    /** uid */
    private Integer id;

    /** 用户名 */
    @ApiModelProperty(value = "用户名", name = "username", example = "kingj", required = true)
    private String name;

    /** 用户密码 */
    @ApiModelProperty(value = "密码", name = "password", example = "123456", required = true)
    private String password;

}
