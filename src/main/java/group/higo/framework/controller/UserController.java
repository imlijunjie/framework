package group.higo.framework.controller;

import group.higo.framework.po.SysUser;
import group.higo.framework.service.ISysUserService;
import group.higo.framework.util.SysUserUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("user")
public class UserController {

    @Resource(name = "sysUserService")
    private ISysUserService sysUserService;

    @RequestMapping("show")
    public String show(Model model){
        SysUser u = sysUserService.selectByPrimaryKey(1);
        model.addAttribute("user",u);
        return "user";
    }

    @RequestMapping("doRegister")
    @ResponseBody
    public String doRegister(SysUser sysUser){
        sysUser = SysUserUtils.getEncryptedUser(sysUser);
        int flag = sysUserService.insertSelective(sysUser);
        return String.valueOf(flag);
    }
}
