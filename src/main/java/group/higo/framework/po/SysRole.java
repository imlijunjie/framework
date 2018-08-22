package group.higo.framework.po;

/**
 * 描述:sys_role表的实体类
 * @version
 * @author:  Longruan
 * @创建时间: 2018-08-22
 */
public class SysRole {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 备注
     */
    private String remark;

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
     * 角色名称
     * @return name 角色名称
     */
    public String getName() {
        return name;
    }

    /**
     * 角色名称
     * @param name 角色名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 备注
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}