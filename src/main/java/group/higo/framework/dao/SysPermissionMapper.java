package group.higo.framework.dao;

import group.higo.framework.po.SysPermission;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("sysPermissionMapper")
public interface SysPermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    SysPermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);
	
	List getSysPermissionByPid(Map map);

	List getSysPermissionByUserid(Integer userid);
}