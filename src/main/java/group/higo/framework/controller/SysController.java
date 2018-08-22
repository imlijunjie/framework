package group.higo.framework.controller;

import group.higo.framework.service.ISysService;
import group.higo.framework.util.PaginationUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("sys")
public class SysController {

    @Resource(name = "sysService")
    private ISysService sysService;

    @RequiresPermissions("user")
    @RequestMapping("sysUserIndex")
    public String sysUserListIndex(){
        return "sysUser";
    }

    @RequestMapping("getSysUserList")
    @ResponseBody
    public Map getSysUserList(PaginationUtils paginationUtils){
        Map param = new HashMap();
        param.put("paginationUtils",paginationUtils);
        List rows = sysService.getSysUserList(param);
        int total = sysService.getSysUserListCount(param);
        Map map = new HashMap();
        map.put("rows",rows);
        map.put("total",total);
        return map;
    }
}
