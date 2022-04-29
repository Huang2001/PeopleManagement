package cn.edu.ecut.controller;

import cn.edu.ecut.pojo.People;
import cn.edu.ecut.service.mapperimp.PeopleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author DRW
 * @vsrsion 1.0
 */
@Controller
@RequestMapping("/Login")
public class LoginController {
    @Resource
    private PeopleService peopleService;
    @RequestMapping("/goLogin")
    public String goLogin(){
      return "login";
    }
    @RequestMapping("/login.do")
    public String login(String userCode, String userPassword, Model model){
        People people=peopleService.queryPeople(userCode,userPassword);
        if (people.getUsername().equals("管理员")) {
            model.addAttribute("people",people);
            return "main";
        }
        else {
            model.addAttribute("msg","用户名或者密码错误");
            return "login";
        }
    }
    @RequestMapping("/goRegister")
    public String goRegister(){
        return "register";
    }
}
