package com.zy.microoffice.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class LoginController {
    @RequestMapping("/")
    public String index(ModelMap map){
        map.put("mymsg","hi,i am zhangyue");
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam("phonenumber")String phonenumber,@RequestParam("pwd")String pwd){
        ModelAndView modelAndView=new ModelAndView();
        if (phonenumber.equals("zhangyue")&&pwd.equals("123")){
            modelAndView.setViewName("index");
        }
        else{
            modelAndView.addObject("error","用户名或者密码不存在");
        }
        return modelAndView;
    }
}
