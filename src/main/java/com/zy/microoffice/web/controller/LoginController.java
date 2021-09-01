package com.zy.microoffice.web.controller;

import com.zy.microoffice.config.ConstValue;
import com.zy.microoffice.entity.UserEntity;
import com.zy.microoffice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.TextUtils;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;

@ApiIgnore
@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String index(ModelMap map) {
        map.put("mymsg", "hi,i am zhangyue");
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("phonenumber") String phonenumber, @RequestParam("pwd") String pwd,@RequestParam("classname") String classname,@RequestParam("admin_classname") String admin_classname, HttpSession httpSession, Model model) {
        classname= StringUtils.isEmpty(admin_classname)?classname:admin_classname;
        boolean isAdmin=!StringUtils.isEmpty(admin_classname);
        UserEntity login = userService.login(phonenumber, pwd,classname,isAdmin);
        if (login != null) {
            //用户登录后将PhoneBumber存入到Session中
            httpSession.setAttribute(ConstValue.USER_PHONENUMBER_KEY, phonenumber);
            httpSession.setAttribute(ConstValue.USER_CLASSNAME,classname);
            return "redirect:index/index";
        } else {
            httpSession.invalidate();
            model.addAttribute("error", "用户名不存在,或者密码输入错误，或者所在班级有误");
        }
        return "login";
    }
}
