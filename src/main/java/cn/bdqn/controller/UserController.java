package cn.bdqn.controller;

import cn.bdqn.pojo.User;
import cn.bdqn.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("list")
    public String list(Model model){
        List<User> list = userService.list();
        model.addAttribute("list",list);
        return "list";
    }

    @RequestMapping("toAdd")
    public String toAdd(){
        return "add";
    }
    @RequestMapping("add")
    public String add(User user){
        userService.add(user);
        return "redirect:/list";
    }
    @RequestMapping("toUpdate")
    public String update(Model model,int id){
        User user = userService.getUserByid(id);
        model.addAttribute("user",user);
        return "update";
    }

    @RequestMapping("update")
    public String update(User user){
        userService.update(user);
        return "redirect:/list";
    }
    @RequestMapping("delete")
    public String delete(int id){
        userService.delete(id);
        return "redirect:/list";
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
