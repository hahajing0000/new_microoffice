package com.zy.microoffice.mapper;

import com.zy.microoffice.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    //添加用户
    boolean register(String phonenumber,String pwd);
    //获取用户信息
    UserEntity getUserById(int id);
    //用户登录
    UserEntity login(String phoneNumber,String pwd);
    //修改用户真实姓名
    boolean modifyRealName(String realName,int id);
    //根据电话号码获取用户信息
    UserEntity getUserByPhoneNumber(String phonenumber);
    //更新token
    boolean modifyToken(int userid,String token);
}
