package group.higo.framework.po;

/**
 * 描述:sys_permission表的实体类
 * @version
 * @author:  Longruan
 * @创建时间: 2018-08-02
 */
public class SysPermission {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String name;

    /**
     * top_menu,left_menu,button
     */
    private String type;

    /**
     * 
     */
    private String url;

    /**
     * 权限编码值（唯一）
     */
    private String percode;

    /**
     * 
     */
    private String pid;

    /**
     * 
     */
    private String pids;

    /**
     * 
     */
    private String orderid;

    /**
     * 
     */
    private String available;

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
     * @return name 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name 
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * top_menu,left_menu,button
     * @return type top_menu,left_menu,button
     */
    public String getType() {
        return type;
    }

    /**
     * top_menu,left_menu,button
     * @param type top_menu,left_menu,button
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 
     * @return url 
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url 
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 权限编码值（唯一）
     * @return percode 权限编码值（唯一）
     */
    public String getPercode() {
        return percode;
    }

    /**
     * 权限编码值（唯一）
     * @param percode 权限编码值（唯一）
     */
    public void setPercode(String percode) {
        this.percode = percode == null ? null : percode.trim();
    }

    /**
     * 
     * @return pid 
     */
    public String getPid() {
        return pid;
    }

    /**
     * 
     * @param pid 
     */
    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    /**
     * 
     * @return pids 
     */
    public String getPids() {
        return pids;
    }

    /**
     * 
     * @param pids 
     */
    public void setPids(String pids) {
        this.pids = pids == null ? null : pids.trim();
    }

    /**
     * 
     * @return orderid 
     */
    public String getOrderid() {
        return orderid;
    }

    /**
     * 
     * @param orderid 
     */
    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    /**
     * 
     * @return available 
     */
    public String getAvailable() {
        return available;
    }

    /**
     * 
     * @param available 
     */
    public void setAvailable(String available) {
        this.available = available == null ? null : available.trim();
    }
}