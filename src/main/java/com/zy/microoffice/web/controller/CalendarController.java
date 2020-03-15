package com.zy.microoffice.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
@RequestMapping("/calendar")
public class CalendarController {

    @RequestMapping(value = "/getdata")
    public String getData(){
        return "calendar";
    }
}
