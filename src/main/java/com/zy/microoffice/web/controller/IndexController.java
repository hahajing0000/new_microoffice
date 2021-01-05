package com.zy.microoffice.web.controller;

import com.zy.microoffice.entity.InterViewCountEntity;
import com.zy.microoffice.entity.StatEntity;
import com.zy.microoffice.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import java.util.*;

@ApiIgnore
@Controller
@RequestMapping(value = "/index")
public class IndexController {

    @Autowired
    StatService statService;

    @RequestMapping("/stat")
    public String gotoStat() {
        return "redirect:/stat/findstats?starttime=&endtime=&page=-1";
    }

    @RequestMapping("/calendar")
    public String gotoCalendar() {
        return "redirect:/calendar/getdata";
    }

    @RequestMapping("/index")
    public String gotoIndex(Model model) {
        //有Offer人数
        int offerCount = statService.getOfferCount();
        //今日面试人数
        int interViewCountToday = statService.getInterViewCountToday();
        //面试成功率
        double interViewSuccess = statService.getInterViewSuccess();
        HashMap<String, Integer> suceessRate = statService.getSuceessRate();
        //有Offer人员信息
        List<StatEntity> statEntityBySuccess = statService.getStatEntityBySuccess();
        if (statEntityBySuccess == null) {
            statEntityBySuccess = new ArrayList<>();
        }
        //今日面试人员信息
        List<StatEntity> statEntityToady = statService.getStatEntityToady();
        if (statEntityToady == null) {
            statEntityToady = new ArrayList<>();
        }

        model.addAttribute("offercount", offerCount);
        model.addAttribute("todaycount", interViewCountToday);
        model.addAttribute("successrate", interViewSuccess);
        model.addAttribute("list", statEntityBySuccess);
        model.addAttribute("toadylist", statEntityToady);
        model.addAttribute("successstat", suceessRate);
//        List<String> keys=new ArrayList<>();
//        List<Integer> values=new ArrayList<>();
//        for (InterViewCountEntity item:
//             userInterViewCount) {
//            keys.add(item.getRealname());
//            values.add(item.getCount());
//        }
//        model.addAttribute("interviewcountkey",keys);
//        model.addAttribute("interviewcountvalues",values);
        return "index";
    }

    @RequestMapping(value = "/getInterViewCount")
    @ResponseBody
    public List<InterViewCountEntity> getInterViewCount() {
        List<InterViewCountEntity> userInterViewCount = statService.getUserInterViewCount();
        return userInterViewCount;
    }

}
