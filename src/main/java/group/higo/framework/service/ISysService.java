package group.higo.framework.service;

import java.util.List;
import java.util.Map;

public interface ISysService {

    List getTopMenu(Integer userid);

    List getSysPermissionTree(Integer pid,String type, Integer userid);

    List getSysUserList(Map param);

    int getSysUserListCount(Map param);

}
