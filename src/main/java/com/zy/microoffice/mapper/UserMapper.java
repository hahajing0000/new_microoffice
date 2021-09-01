package com.zy.microoffice.mapper;

import com.zy.microoffice.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {
    //添加用户
    void register(Map<String, String> param);

    //获取用户信息
    UserEntity getUserById(int id);

    //用户登录
    UserEntity login(String phoneNumber, String pwd,String classname,boolean isAdmin);

    //修改用户真实姓名
    boolean modifyRealName(String realName, int id);

    //根据电话号码获取用户信息
    UserEntity getUserByPhoneNumber(String phonenumber);

    //更新token
    boolean modifyToken(int userid, String token);

    //修改用户头像
    boolean modifyHeadImg(int userid, String headimg);
}
