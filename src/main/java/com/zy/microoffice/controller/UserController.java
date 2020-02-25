package com.zy.microoffice.controller;

import com.zy.microoffice.entity.UserEntity;
import com.zy.microoffice.service.TokenServiceImpl;
import com.zy.microoffice.service.UserService;
import com.zy.microoffice.token.UserLoginToken;
import io.swagger.annotations.*;
import javafx.scene.chart.ValueAxis;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api(value = "用户模块API接口",description = "该模块提供对用户信息的CRUD操作",tags = "用户模块")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    TokenServiceImpl tokenService;

    @ApiOperation(value = "添加用户",notes = "添加用户方法",httpMethod = "POST")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "String",name = "phonenumber",value = "电话号码",required = true),
            @ApiImplicitParam(dataType = "String",name = "pwd",value = "密码",required = true)
    })
    @PostMapping("/register")
    public boolean register(@RequestParam String phonenumber,@RequestParam String pwd){

        return userService.register(phonenumber,pwd);
    }


    @ApiOperation(value = "根据id获取用户信息",notes = "根据id获取用户信息",httpMethod = "GET")
    @ApiImplicitParam(value = "主键id",dataType = "String",name = "id",required = true)
    @GetMapping("/getUserById")
    public UserEntity getUserById(int id){
        return userService.getUserById(id);
    }

    @ApiOperation(value = "用户登录方法",notes = "根据用户名密码登录",httpMethod = "POST")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "String",name = "phoneNumber",value = "电话号码",required = true),
            @ApiImplicitParam(dataType = "String",name = "pwd",value = "密码",required = true)
    })
    @PostMapping("/login")
    public UserEntity login(String phoneNumber,String pwd){
        UserEntity userEntity= userService.login(phoneNumber,pwd);
        String token=tokenService.getToken(userEntity);
        userEntity.setToken(token);
        return userEntity;
    }

    @UserLoginToken
    @ApiOperation(value = "更改用户真实姓名",notes = "更改用户真实姓名",httpMethod = "POST")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "String",name = "realName",value = "真实姓名",required = true),
            @ApiImplicitParam(dataType = "int",name = "id",value = "用户id",required = true)
    })
    @PostMapping("/modifyRealName")
    public boolean modifyRealName(String realName,int id){
        return userService.modifyRealName(realName,id);
    }

    @ResponseBody
    @ApiOperation(value = "token测试",notes = "验证token是否已经生效",httpMethod = "GET")
    @UserLoginToken
    @GetMapping("/tokenTest")
    public String tokenTest(){
        return "恭喜！token已经生效！！！";
    }

}

