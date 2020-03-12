package com.zy.microoffice.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class IndexController {

    @RequestMapping("/stat")
    public String gotoStat(){
        return "redirect:stat/findstats";
    }
}
