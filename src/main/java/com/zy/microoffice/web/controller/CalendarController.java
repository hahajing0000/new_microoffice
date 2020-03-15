package com.zy.microoffice.web.controller;

import com.zy.microoffice.entity.CalendarEntity;
import com.zy.microoffice.entity.StatEntity;
import com.zy.microoffice.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@ApiIgnore
@Controller
@RequestMapping("/calendar")
public class CalendarController {

    @Autowired
    StatService statService;

    @RequestMapping(value = "/getdata")
    public String getData(Model model){

        return "calendar";
    }

    @RequestMapping(value = "/loadData")
    @ResponseBody
    public List<CalendarEntity>  loadData(){
        List<CalendarEntity> calendarData = statService.getCalendarData();
        return calendarData;
    }

    @RequestMapping(value = "/gotoStatDetail")
    public String gotoStatDetail(int id,Model model){
        StatEntity stat = statService.getStatById(id);
        model.addAttribute("stat", stat);
        model.addAttribute("flag", "calendar");
        return "statedit";
    }

}
