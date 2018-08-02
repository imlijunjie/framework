package group.higo.framework.dao;

import group.higo.framework.po.SysRolePermission;
import org.springframework.stereotype.Repository;

@Repository("sysRolePermissionMapper")
public interface SysRolePermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);

    SysRolePermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRolePermission record);

    int updateByPrimaryKey(SysRolePermission record);
}