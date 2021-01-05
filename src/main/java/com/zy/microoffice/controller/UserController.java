package com.zy.microoffice.controller;

import com.zy.microoffice.entity.ResponseEntity;
import com.zy.microoffice.entity.ResponseUtils;
import com.zy.microoffice.entity.UserEntity;
import com.zy.microoffice.service.TokenServiceImpl;
import com.zy.microoffice.service.UserService;
import com.zy.microoffice.token.UserLoginToken;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api(value = "用户模块API接口", description = "该模块提供对用户信息的CRUD操作", tags = "用户模块")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    TokenServiceImpl tokenService;

    @ApiOperation(value = "注册用户", notes = "注册用户方法", httpMethod = "POST")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "String", name = "phonenumber", value = "电话号码", required = true),
            @ApiImplicitParam(dataType = "String", name = "pwd", value = "密码", required = true)
    })
    @PostMapping("/register")
    public ResponseEntity register(@RequestParam String phonenumber, @RequestParam String pwd) {

        return userService.register(phonenumber, pwd);
    }


    @ApiOperation(value = "根据id获取用户信息", notes = "根据id获取用户信息", httpMethod = "GET")
    @ApiImplicitParam(value = "主键id", dataType = "String", name = "id", required = true)
    @GetMapping("/getUserById")
    public ResponseEntity<UserEntity> getUserById(int id) {
        UserEntity user = userService.getUserById(id);
        user.setPwd("");
        return ResponseUtils.success(user);
    }

    @ApiOperation(value = "用户登录方法", notes = "根据用户名密码登录", httpMethod = "POST")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "String", name = "phoneNumber", value = "电话号码", required = true),
            @ApiImplicitParam(dataType = "String", name = "pwd", value = "密码", required = true)
    })
    @PostMapping("/login")
    public ResponseEntity<UserEntity> login(String phoneNumber, String pwd) {
        UserEntity userEntity = userService.login(phoneNumber, pwd);
        if (userEntity == null) {
            return ResponseUtils.failed("用户名或者密码不正确");
        }
        String token = tokenService.getToken(userEntity);
        userEntity.setToken(token);

        return ResponseUtils.success(userEntity);
    }

    @UserLoginToken
    @ApiOperation(value = "更改用户真实姓名", notes = "更改用户真实姓名", httpMethod = "PUT")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "String", name = "realName", value = "真实姓名", required = true),
            @ApiImplicitParam(dataType = "int", name = "id", value = "用户id", required = true)
    })
    @PutMapping("/modifyRealName")
    public ResponseEntity<Boolean> modifyRealName(String realName, int id) {
        return userService.modifyRealName(realName, id);
    }

    @ResponseBody
    @ApiOperation(value = "token测试", notes = "验证token是否已经生效", httpMethod = "GET")
    @UserLoginToken
    @GetMapping("/tokenTest")
    public ResponseEntity<String> tokenTest() {
        return ResponseUtils.success("恭喜！token已经生效！！！");
    }


    @ApiOperation(value = "获取手机验证码", notes = "获取手机验证码", httpMethod = "GET")
    @GetMapping("/getAuthCode")
    public ResponseEntity getAuthCode() {
        return userService.getAuthCode();
    }

    /**
     * 根据电话号码获取用户实体
     *
     * @param phonenumber 电话号码
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "根据电话号码获取用户实体", notes = "根据电话号码获取用户实体", httpMethod = "GET")
    @GetMapping("/getUserByPhoneNumber")
    public ResponseEntity<UserEntity> getUserByPhoneNumber(@RequestParam
                                                           @ApiParam(name = "phonenumber", value = "电话号码", required = true)
                                                                   String phonenumber) {
        return userService.getUserByPhoneNumber(phonenumber);
    }

    /**
     * 修改用户头像
     *
     * @param userid  用户id
     * @param headimg 用户头像
     * @return
     */
    @UserLoginToken
    @ApiOperation(value = "修改用户头像", notes = "修改用户头像", httpMethod = "PUT")
    @PutMapping("/modifyHeadImg")
    public ResponseEntity modifyHeadImg(int userid, String headimg) {
        return userService.modifyHeadImg(userid, headimg);
    }
}

