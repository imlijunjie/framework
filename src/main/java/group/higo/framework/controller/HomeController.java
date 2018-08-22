package group.higo.framework.controller;

import group.higo.framework.po.SysPermission;
import group.higo.framework.po.SysUser;
import group.higo.framework.service.ISysService;
import group.higo.framework.util.MyTree;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("home")
public class HomeController {

    @Resource(name = "sysService")
    private ISysService sysService;

    @RequestMapping("getZtreeJson")
    @ResponseBody
    public List<MyTree> getZtreeJson(Integer id,String type) {
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        return sysService.getSysPermissionTree(id,type,user.getId());
    }

    @RequestMapping("getTopMenu")
    @ResponseBody
    public List<SysPermission> getTopMenu(){
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        return sysService.getTopMenu(user.getId());
    }
}
