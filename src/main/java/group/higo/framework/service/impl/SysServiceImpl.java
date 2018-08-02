package group.higo.framework.service.impl;

import group.higo.framework.dao.SysPermissionMapper;
import group.higo.framework.po.SysPermission;
import group.higo.framework.service.ISysService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("sysService")
@Transactional
public class SysServiceImpl implements ISysService {

    @Resource(name = "sysPermissionMapper")
    private SysPermissionMapper sysPermissionMapper;


    @Override
    public SysPermission getSysPermissionById(Integer id) {
        return sysPermissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public List getSysPermissionByPid(Integer id) {
        return sysPermissionMapper.getSysPermissionByPid(id);
    }
}
