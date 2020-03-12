package com.zy.microoffice.web.controller;

import com.zy.microoffice.entity.StatEntity;
import com.zy.microoffice.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@ApiIgnore
@Controller
@RequestMapping("/stat")
public class StatController {
    @Autowired
    StatService statService;

    @RequestMapping("/")
    public String init(Model model){
        List<StatEntity> stats = statService.getStats("", "");
        model.addAttribute("list",stats);
        return "stat";
    }

    @RequestMapping(value = "/findstats")
    public String FindStat(Model model,String starttime,String endtime){
//        if (starttime==null){starttime="";}
//        if(endtime==null){endtime="";}
        List<StatEntity> stats = statService.getStats(starttime, endtime);
        model.addAttribute("list",stats);
        return "stat";
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "statedit";
    }

    @PostMapping(value = "/insert")
    public String insert(StatEntity statEntity, BindingResult bindingResult){
        statService.addStat(statEntity);
        return "redirect:findstats";
    }

    @PostMapping(value = "/modify")
    public String modify(StatEntity statEntity, BindingResult bindingResult){
        statService.modifyStat(statEntity);
        return "redirect:findstats";
    }

    @RequestMapping(value = "/delete")
    public String delete(int id){
        statService.remove(id);
        return "redirect:findstats";
    }

    @RequestMapping(value = "/getId")
    public String getId(Model model,int id){
        StatEntity statById = statService.getStatById(id);
        model.addAttribute("stat",statById);
        return "statedit";
    }
}
