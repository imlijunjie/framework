package group.higo.framework.service.impl;

import group.higo.framework.dao.UserMapper;
import group.higo.framework.po.User;
import group.higo.framework.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource(name = "userMapper")
    private UserMapper userMapper;

    public User selectByPrimaryKey(Integer id) {
        return this.userMapper.selectByPrimaryKey(id);
    }
}
