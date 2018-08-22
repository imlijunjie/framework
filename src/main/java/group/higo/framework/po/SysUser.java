package group.higo.framework.po;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述:sys_user表的实体类
 * @version
 * @author:  Longruan
 * @创建时间: 2018-08-22
 */
public class SysUser implements Serializable{
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 状态
     */
    private String status;

    /**
     * 注册时间
     */
    private Date registerTime;

    /**
     * 主键ID
     * @return id 主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键ID
     * @param id 主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 账号
     * @return username 账号
     */
    public String getUsername() {
        return username;
    }

    /**
     * 账号
     * @param username 账号
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 密码
     * @return password 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 盐
     * @return salt 盐
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 盐
     * @param salt 盐
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * 状态
     * @return status 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 注册时间
     * @return register_time 注册时间
     */
    public Date getRegisterTime() {
        return registerTime;
    }

    /**
     * 注册时间
     * @param registerTime 注册时间
     */
    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }
}