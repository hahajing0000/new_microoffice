package com.zy.microoffice.service;

import com.zy.microoffice.entity.ResponseEntity;
import com.zy.microoffice.entity.ResponseUtils;
import com.zy.microoffice.entity.UserEntity;
import com.zy.microoffice.mapper.UserMapper;
import com.zy.microoffice.utils.NumberUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 添加用户信息
     *
     * @param pn
     * @param p
     * @return
     */
    public ResponseEntity register(String pn, String p) {
        boolean r = false;
        Map<String, String> param = new HashMap<String, String>();
        param.put("pn", pn);
        param.put("p", p);
        param.put("result", "");
        userMapper.register(param);
        String result = param.get("result");

        if (result.equals("1")) {
            r = true;
        } else {
            r = false;
            return ResponseUtils.failed("用户可能已经存在");
        }
        return ResponseUtils.success(r);
    }

    /**
     * 更加id或者用实体对象
     *
     * @param id
     * @return
     */
    public UserEntity getUserById(int id) {
        log.debug("执行了getUserById方法。。。");
        return userMapper.getUserById(id);
    }

    /**
     * 用户登录方法
     *
     * @param phoneNumber 电话号码
     * @param pwd         密码
     * @return
     */
    public UserEntity login(String phoneNumber, String pwd,String classname,boolean isAdmin) {
        return userMapper.login(phoneNumber, pwd,classname,isAdmin);
    }

    /**
     * 修改用户真实姓名
     *
     * @param realName 真实姓名
     * @param id       用户id
     * @return
     */
    public ResponseEntity<Boolean> modifyRealName(String realName, int id) {
        return ResponseUtils.success(userMapper.modifyRealName(realName, id));
    }

    /**
     * 根据电话号码获取用户实体
     *
     * @param phonenumber 电话号码
     * @return
     */
    public ResponseEntity<UserEntity> getUserByPhoneNumber(String phonenumber) {
        return ResponseUtils.success(userMapper.getUserByPhoneNumber(phonenumber));
    }

    /**
     * 获取手机验证码
     *
     * @return
     */
    public ResponseEntity getAuthCode() {
        return ResponseUtils.success(NumberUtils.getNumberByRange(100000, 999999));
    }

    /**
     * 更加用户id更新token
     *
     * @param userid 用户id
     * @param token  token
     * @return
     */
    public boolean modifyToken(int userid, String token) {
        return userMapper.modifyToken(userid, token);
    }

    /**
     * 修改用户头像
     *
     * @param userid  用户id
     * @param headimg 用户头像
     * @return
     */
    public ResponseEntity modifyHeadImg(int userid, String headimg) {
        return ResponseUtils.success(userMapper.modifyHeadImg(userid, headimg));
    }
}
