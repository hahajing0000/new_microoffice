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

    @RequestMapping("/toEdit")
    public String toEdit(int id,Model model){
        StatEntity stat = statService.getStatById(id);
        model.addAttribute("stat", stat);
        return "statedit";
    }

    @PostMapping(value = "/insert")
    public String insert(StatEntity statEntity,BindingResult bindingResult, HttpSession session){
//        if (bindingResult.hasErrors()){
//            for (ObjectError error:
//                 bindingResult.getAllErrors()) {
//               String field=  bindingResult.getFieldError().getField();
//               String e=bindingResult.getFieldError().getDefaultMessage();
//               model.addAttribute(field, e);
//               break;
//            }
//            return "statedit";
//        }
        //从Session中获取PhoneNumber
        String phonenumber= (String) session.getAttribute(ConstValue.USER_PHONENUMBER_KEY);
        statEntity.setPhonenumber(phonenumber);
        statService.addStat(statEntity);
        return "redirect:findstats";
    }

    @PostMapping(value = "/modify")
    public String modify(StatEntity statEntity,BindingResult bindingResult){
        statService.modifyStat(statEntity);
        return "redirect:findstats";
    }

    /**
     * 通过面试
     * @param id
     * @return
     */
    @PostMapping(value = "/pass")
    public String pass(int id){
         statService.pass(id);
         return "redirect:findstats";
    }

    /**
     * 面试失败
     * @param id
     * @return
     */
    @PostMapping(value = "/failed")
    public String failed(int id){
        statService.failed(id);
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
