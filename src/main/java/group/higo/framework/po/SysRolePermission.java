package group.higo.framework.po;

/**
 * 描述:sys_role_permission表的实体类
 * @version
 * @author:  Longruan
 * @创建时间: 2018-08-22
 */
public class SysRolePermission {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 角色ID
     */
    private Integer roleid;

    /**
     * 权限ID
     */
    private Integer permissionid;

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

    /**
     * 权限ID
     * @return permissionid 权限ID
     */
    public Integer getPermissionid() {
        return permissionid;
    }

    /**
     * 权限ID
     * @param permissionid 权限ID
     */
    public void setPermissionid(Integer permissionid) {
        this.permissionid = permissionid;
    }
}