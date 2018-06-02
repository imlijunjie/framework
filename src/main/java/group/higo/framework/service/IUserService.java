package group.higo.framework.service;

import group.higo.framework.po.User;

public interface IUserService {
    User selectByPrimaryKey(Integer id);

    User selectByUsername(String username);
}
