package group.higo.framework.service.impl;

import group.higo.framework.dao.SysUserMapper;
import group.higo.framework.po.SysUser;
import group.higo.framework.service.ISysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("sysUserService")
public class SysUserServiceImpl implements ISysUserService {

    @Resource(name = "sysUserMapper")
    private SysUserMapper sysUserMapper;

    public SysUser selectByPrimaryKey(String id) {
        return this.sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public SysUser selectByUsername(String username) {
        return sysUserMapper.selectByUsername(username);
    }

    @Override
    public int insertSelective(SysUser record) {
        return sysUserMapper.insertSelective(record);
    }
}
