package com.zy.microoffice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

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
