package group.higo.framework.po;

/**
 * 描述:sys_role_permission表的实体类
 * @version
 * @author:  Longruan
 * @创建时间: 2018-08-02
 */
public class SysRolePermission {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer roleid;

    /**
     * 
     */
    private Integer permissionid;

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
     * @return roleid 
     */
    public Integer getRoleid() {
        return roleid;
    }

    /**
     * 
     * @param roleid 
     */
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    /**
     * 
     * @return permissionid 
     */
    public Integer getPermissionid() {
        return permissionid;
    }

    /**
     * 
     * @param permissionid 
     */
    public void setPermissionid(Integer permissionid) {
        this.permissionid = permissionid;
    }
}