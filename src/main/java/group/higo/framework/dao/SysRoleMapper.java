package group.higo.framework.dao;

import group.higo.framework.po.SysRole;
import org.springframework.stereotype.Repository;

@Repository("sysRoleMapper")
public interface SysRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
}