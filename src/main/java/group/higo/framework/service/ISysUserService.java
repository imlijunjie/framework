package group.higo.framework.service;

import group.higo.framework.po.SysUser;

public interface ISysUserService {
    SysUser selectByPrimaryKey(Integer id);

    SysUser selectByUsername(String username);

    int insertSelective(SysUser record);
}
