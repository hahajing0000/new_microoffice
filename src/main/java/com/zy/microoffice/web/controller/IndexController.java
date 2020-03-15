package com.zy.microoffice.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
@RequestMapping(value = "/index")
public class IndexController {

    @RequestMapping("/stat")
    public String gotoStat(){
        return "redirect:/stat/findstats";
    }

    @RequestMapping("/calendar")
    public String gotoCalendar(){
        return "redirect:/calendar/getdata";
    }

    @RequestMapping("/index")
    public String gotoIndex(){
        return "index";
    }
}
