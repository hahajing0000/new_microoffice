package com.zy.microoffice.web.controller;

import com.zy.microoffice.config.ConstValue;
import com.zy.microoffice.entity.UserEntity;
import com.zy.microoffice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;

@ApiIgnore
@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String index(ModelMap map){
        map.put("mymsg","hi,i am zhangyue");
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("phonenumber")String phonenumber, @RequestParam("pwd")String pwd, HttpSession httpSession, Model model){

        UserEntity login = userService.login(phonenumber, pwd);
        if (login!=null){
            //用户登录后将PhoneBumber存入到Session中
            httpSession.setAttribute(ConstValue.USER_PHONENUMBER_KEY, phonenumber);
            return "redirect:index/index";
        }
        else{
            httpSession.invalidate();
            model.addAttribute("error","用户名或者密码不存在");
        }
        return "login";
    }
}
