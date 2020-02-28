package com.zy.microoffice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.beans.Transient;

@Data
@ApiModel(value = "用户信息" ,description = "用户信息")
public class UserEntity {

    @ApiModelProperty(value = "用户id")
    private int id;
    @ApiModelProperty(value = "电话号码")
    private String phonenumber;
    @ApiModelProperty(value = "密码")
    private String pwd;
    @ApiModelProperty(value = "真实姓名")
    private String realname;
    @ApiModelProperty(value = "token令牌")
    private String token;
    @ApiModelProperty(value = "头像")
    private String headimg;

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", phonenumber='" + phonenumber + '\'' +
                ", pwd='" + pwd + '\'' +
                ", realname='" + realname + '\'' +
                '}';
    }
}
