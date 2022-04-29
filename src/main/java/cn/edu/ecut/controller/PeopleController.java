package cn.edu.ecut.controller;

import cn.edu.ecut.pojo.People;
import cn.edu.ecut.service.mapperimp.PeopleService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.naming.Name;
import java.util.Date;
import java.util.List;

/**
 * @author DRW
 * @vsrsion 1.0
 */
@Controller
@RequestMapping("/people")
public class PeopleController {
    @Resource
    private PeopleService peopleService;
    @RequestMapping("/goMain")
    public String goMain(){
        return "main";
    }
    @RequestMapping("/goPeopleView")
    public String goPeopleView(@RequestParam(defaultValue = "1") int page,
                               @RequestParam(defaultValue = "4") int size,
                               @RequestParam(name="username",required = false) String username,
                               @RequestParam(name = "address",required = false) String address,
                               @RequestParam(name = "state",required = false) String state,
                               @RequestParam(name = "gender",required = false) String gender, Model model)
    {
        List<People> peopleList=peopleService.queryPeopleList(page,size,username,address,state,gender);
        PageInfo<People> pageInfo=new PageInfo<>(peopleList);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("username",username);
        model.addAttribute("address",address);
        model.addAttribute("state",state);
        model.addAttribute("gender",gender);
        return "peopleList";
    }
    @RequestMapping("/deletePeople")
    public String deletePeopleById(int id){
        peopleService.deletePeopleById(id);
        return "redirect:/people/goPeopleView";
    }
    @RequestMapping("/goUpdate")
    public String goUpdate(int id,Model model){
        People people=peopleService.queryPeopleById(id);
        model.addAttribute("people",people);
        return "updatePeople";
    }
    @RequestMapping("/updatePeople")
    public String updatePeople(People people){
        peopleService.updatePeople(people);
        return "redirect:/people/goPeopleView";
    }
    @RequestMapping("/toAddPeople")
    public String toAddPeople(){
        return "addPeople";
    }
    @RequestMapping("/addPeople")
    public String addPeople(People people,Model model){
        People people1=peopleService.queryPeopleByCode(people.getUserCode());
        if (people1==null){
            peopleService.addPeople(people);
            return "redirect:/people/goPeopleView";
        }
        else {
            model.addAttribute("msg","用户名已存在");
            return "addPeople";
        }
    }
    @RequestMapping("/registerPeople")
    public String registerPeople(People people,Model model){
        People people1=peopleService.queryPeopleByCode(people.getUserCode());
        if (people1==null) {
            Date date=new Date();
            people.setApplicationTime(date);
            people.setRoleName("普通用户");
            peopleService.addPeople(people);
            return "redirect:/people/goPeopleView";
        }
        else {
            model.addAttribute("msg","用户已存在");
            return "login";
        }
    }
}
