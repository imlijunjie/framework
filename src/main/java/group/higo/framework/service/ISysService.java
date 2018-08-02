package group.higo.framework.service;

import group.higo.framework.po.SysPermission;

import java.util.List;

public interface ISysService {

    SysPermission getSysPermissionById(Integer id);

    List getSysPermissionByPid(Integer id);
}
