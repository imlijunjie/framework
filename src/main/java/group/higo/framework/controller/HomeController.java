package group.higo.framework.controller;

import group.higo.framework.po.SysPermission;
import group.higo.framework.service.ISysService;
import group.higo.framework.util.MyTree;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("home")
public class HomeController {

    @Resource(name = "sysService")
    private ISysService sysService;

    @RequestMapping("getZtreeJson")
    @ResponseBody
    public List<MyTree> getZtreeJson(Integer id) {
        if(id == null){
            id = 0;
        }
        List<MyTree> zTrees = null;
        List<SysPermission> list = this.sysService.getSysPermissionByPid(id);
        if (null != list && list.size() > 0) {
            zTrees = new ArrayList<>();
            for (SysPermission sysPermission : list) {
                MyTree tree = this.getEmergencyDetailTreeNode(sysPermission);
                zTrees.add(tree);
            }
        }
        return zTrees;
    }

    public MyTree getEmergencyDetailTreeNode(SysPermission sysPermission) {
        MyTree tree = new MyTree();
        tree.setId(sysPermission.getId().toString());
        tree.setText(sysPermission.getName());
        tree.setObj(sysPermission);
        List<SysPermission> list = this.sysService.getSysPermissionByPid(sysPermission.getId());
        List<MyTree> zTrees = new ArrayList<>();
        if (null != list && list.size() > 0) {
            tree.setOpen(true);
            for (SysPermission permission : list) {
                MyTree zTree = this.getEmergencyDetailTreeNode(permission);
                zTrees.add(zTree);
            }
        }
        tree.setChildren(zTrees);
        return tree;
    }

    @RequestMapping("getTopMenu")
    @ResponseBody
    public List<SysPermission> getTopMenu(Integer id){
        List<SysPermission> top_menu = sysService.getSysPermissionByPid(id);
        return top_menu;
    }
}
