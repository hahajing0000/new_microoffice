package com.zy.microoffice.service;

import com.zy.microoffice.entity.UserEntity;
import com.zy.microoffice.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 添加用户信息
     * @param phonenumber
     * @param pwd
     * @return
     */
    public boolean register(String phonenumber,String pwd){

        return userMapper.register(phonenumber,pwd);
    }

    /**
     * 更加id或者用实体对象
     * @param id
     * @return
     */
    public UserEntity getUserById(int id){
        log.debug("执行了getUserById方法。。。");
        return userMapper.getUserById(id);
    }

    /**
     * 用户登录方法
     * @param phoneNumber 电话号码
     * @param pwd 密码
     * @return
     */
    public UserEntity login(String phoneNumber,String pwd){
        return userMapper.login(phoneNumber,pwd);
    }

    /**
     * 修改用户真实姓名
     * @param realName 真实姓名
     * @param id 用户id
     * @return
     */
    public boolean modifyRealName(String realName,int id){
        return userMapper.modifyRealName(realName,id);
    }
}
