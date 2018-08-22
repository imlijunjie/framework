package group.higo.framework.dao;

import group.higo.framework.po.SysUserRole;
import org.springframework.stereotype.Repository;

@Repository("sysUserRoleMapper")
public interface SysUserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);
}