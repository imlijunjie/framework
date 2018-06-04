package group.higo.framework.po;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述:user表的实体类
 * @version
 * @author:  Longruan
 * @创建时间: 2018-06-01
 */
public class User implements Serializable{
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String username;

    /**
     * 
     */
    private String password;

    /**
     * 
     */
    private String salt;

    /**
     * 
     */
    private String status;

    /**
     * 
     */
    private Date registerTime;

    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return username 
     */
    public String getUsername() {
        return username;
    }

    /**
     * 
     * @param username 
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 
     * @return password 
     */
    public String getPassword() {
        return password;
    }

    /**
     * 
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 
     * @return salt 
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 
     * @param salt 
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * 
     * @return status 
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status 
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 
     * @return register_time 
     */
    public Date getRegisterTime() {
        return registerTime;
    }

    /**
     * 
     * @param registerTime 
     */
    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }
}