package group.higo.framework.po;

/**
 * 描述:sys_user_role表的实体类
 * @version
 * @author:  Longruan
 * @创建时间: 2018-08-22
 */
public class SysUserRole {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userid;

    /**
     * 角色ID
     */
    private Integer roleid;

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
     * 用户ID
     * @return userid 用户ID
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * 用户ID
     * @param userid 用户ID
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * 角色ID
     * @return roleid 角色ID
     */
    public Integer getRoleid() {
        return roleid;
    }

    /**
     * 角色ID
     * @param roleid 角色ID
     */
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
}