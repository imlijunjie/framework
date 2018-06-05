package group.higo.framework.dao;

import group.higo.framework.po.SysUser;
import org.springframework.stereotype.Repository;

@Repository("sysUserMapper")
public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    SysUser selectByUsername(String username);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}