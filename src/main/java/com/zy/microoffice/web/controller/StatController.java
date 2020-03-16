package com.zy.microoffice.web.controller;

import com.zy.microoffice.config.ConstValue;
import com.zy.microoffice.entity.StatEntity;
import com.zy.microoffice.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@ApiIgnore
@Controller
@RequestMapping("/stat")
public class StatController {
    @Autowired
    StatService statService;

    @RequestMapping("/")
    public String init(Model model){
        List<StatEntity> stats = statService.getStats("","", "",-1);
        model.addAttribute("list",stats);
        return "stat";
    }

    @RequestMapping(value = "/findstats")
    public String FindStat(Model model,String starttime,String endtime,int page,HttpSession httpSession){
//        if (starttime==null){starttime="";}
//        if(endtime==null){endtime="";}
        String phonenumber= (String) httpSession.getAttribute(ConstValue.USER_PHONENUMBER_KEY);
        if (phonenumber.toLowerCase().trim().equals("admin")){
            phonenumber="";
        }
        List<StatEntity> stats = statService.getStats(phonenumber,starttime, endtime,page);
        model.addAttribute("list",stats);
        int dataCount = statService.getDataCount(phonenumber);
        model.addAttribute("datacount", dataCount);
        return "stat";
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "statedit";
    }

    @RequestMapping("/toEdit")
    public String toEdit(int id,Model model){
        StatEntity stat = statService.getStatById(id);
        model.addAttribute("stat", stat);
        return "statedit";
    }

    @PostMapping(value = "/insert")
    public String insert(StatEntity statEntity,BindingResult bindingResult, HttpSession session){
        //从Session中获取PhoneNumber
        String phonenumber= (String) session.getAttribute(ConstValue.USER_PHONENUMBER_KEY);
        statEntity.setPhonenumber(phonenumber);
        statService.addStat(statEntity);
        return "redirect:findstats?starttime=&endtime=&page=-1";
    }

    @PostMapping(value = "/modify")
    public String modify(StatEntity statEntity,BindingResult bindingResult){
        statService.modifyStat(statEntity);
        return "redirect:findstats?starttime=&endtime=&page=-1";
    }

    /**
     * 通过面试
     * @param id
     * @return
     */
    @PostMapping(value = "/pass")
    public String pass(int id){
         statService.pass(id);
         return "redirect:findstats?starttime=&endtime=&page=-1";
    }

    /**
     * 面试失败
     * @param id
     * @return
     */
    @PostMapping(value = "/failed")
    public String failed(int id){
        statService.failed(id);
        return "redirect:findstats?starttime=&endtime=&page=-1";
    }

    @RequestMapping(value = "/delete")
    public String delete(int id){
        statService.remove(id);
        return "redirect:findstats?starttime=&endtime=&page=-1";
    }

    @RequestMapping(value = "/getId")
    public String getId(Model model,int id){
        StatEntity statById = statService.getStatById(id);
        model.addAttribute("stat",statById);
        return "statedit";
    }
}
