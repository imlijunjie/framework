package group.higo.framework.controller;

import group.higo.framework.po.User;
import group.higo.framework.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("user")
public class UserController {

    @Resource(name = "userService")
    private IUserService userService;

    @RequestMapping("show")
    public String show(Model model){
        User u = userService.selectByPrimaryKey(1);
        model.addAttribute("user",u);
        return "user";
    }
}
