package group.higo.framework.po;

/**
 * 描述:sys_role表的实体类
 * @version
 * @author:  Longruan
 * @创建时间: 2018-08-02
 */
public class SysRole {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String rolename;

    /**
     * 
     */
    private String remark;

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
     * @return rolename 
     */
    public String getRolename() {
        return rolename;
    }

    /**
     * 
     * @param rolename 
     */
    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    /**
     * 
     * @return remark 
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 
     * @param remark 
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}