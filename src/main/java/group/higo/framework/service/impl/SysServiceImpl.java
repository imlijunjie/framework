package group.higo.framework.service.impl;

import com.alibaba.druid.sql.PagerUtils;
import group.higo.framework.dao.SysPermissionMapper;
import group.higo.framework.dao.SysUserMapper;
import group.higo.framework.po.SysPermission;
import group.higo.framework.service.ISysService;
import group.higo.framework.util.MyTree;
import group.higo.framework.util.PaginationUtils;
import group.higo.framework.util.SysUserUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("sysService")
@Transactional
public class SysServiceImpl implements ISysService {

    @Resource(name = "sysPermissionMapper")
    private SysPermissionMapper sysPermissionMapper;

    @Resource(name = "sysUserMapper")
    private SysUserMapper sysUserMapper;

    @Override
    public List getTopMenu(Integer userid) {
        Map<String,Object> param = new HashMap<>();
        param.put("pid",0);
        param.put("type","menu");
        if(!SysUserUtils.isAdministrator()) {
            //不是管理员，加载系统设置的权限
            param.put("userid",userid);
        }
        return sysPermissionMapper.getSysPermissionByPid(param);
    }

    private List<MyTree> getSysPermissionList(Map param) {
        List<MyTree> zTrees = null;
        List<SysPermission> list = this.sysPermissionMapper.getSysPermissionByPid(param);
        if (null != list && list.size() > 0) {
            zTrees = new ArrayList<>();
            for (SysPermission sysPermission : list) {
                param.put("pid",sysPermission.getId());
                MyTree tree = this.getTreeNode(sysPermission,param);
                zTrees.add(tree);
            }
        }
        return zTrees;
    }

    private MyTree getTreeNode(SysPermission sysPermission,Map param) {
        MyTree tree = new MyTree();
        tree.setId(sysPermission.getId().toString());
        tree.setText(sysPermission.getName());
        tree.setObj(sysPermission);
        List<SysPermission> list = this.sysPermissionMapper.getSysPermissionByPid(param);
        List<MyTree> zTrees = new ArrayList<>();
        if (null != list && list.size() > 0) {
            tree.setOpen(true);
            for (SysPermission permission : list) {
                param.put("pid",permission.getId());
                MyTree zTree = this.getTreeNode(permission,param);
                zTrees.add(zTree);
            }
        }
        tree.setChildren(zTrees);
        return tree;
    }

    @Override
    public List getSysPermissionTree(Integer pid, String type, Integer userid) {
        if(pid == null){
            pid = 0;
        }
        Map<String,Object> param = new HashMap<>();
        param.put("pid",pid);
        param.put("type",type);
        if(!SysUserUtils.isAdministrator()) {
            //不是管理员，加载系统设置的权限
            param.put("userid",userid);
        }
        return this.getSysPermissionList(param);
    }

    @Override
    public List getSysUserList(Map param) {
        return sysUserMapper.getSysUserList(param);
    }

    @Override
    public int getSysUserListCount(Map param) {
        return sysUserMapper.getSysUserListCount(param);
    }
}
