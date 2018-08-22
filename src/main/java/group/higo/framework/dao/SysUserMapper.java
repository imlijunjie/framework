package group.higo.framework.dao;

import group.higo.framework.po.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("sysUserMapper")
public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
	
	SysUser selectByUsername(String username);

	List getSysUserList(Map param);

	int getSysUserListCount(Map param);
}