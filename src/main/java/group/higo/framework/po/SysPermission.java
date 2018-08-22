package group.higo.framework.po;

/**
 * 描述:sys_permission表的实体类
 * @version
 * @author:  Longruan
 * @创建时间: 2018-08-22
 */
public class SysPermission {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 类型：top_menu,left_menu,button
     */
    private String type;

    /**
     * 请求地址
     */
    private String url;

    /**
     * 图标
     */
    private String icon;

    /**
     * 权限编码值（唯一）
     */
    private String percode;

    /**
     * 父节点ID
     */
    private Integer pid;

    /**
     * 父节点串
     */
    private String pids;

    /**
     * 排序
     */
    private String orderid;

    /**
     * 启用状态
     */
    private String available;

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
     * 名称
     * @return name 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 名称
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 类型：top_menu,left_menu,button
     * @return type 类型：top_menu,left_menu,button
     */
    public String getType() {
        return type;
    }

    /**
     * 类型：top_menu,left_menu,button
     * @param type 类型：top_menu,left_menu,button
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 请求地址
     * @return url 请求地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 请求地址
     * @param url 请求地址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 图标
     * @return icon 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 图标
     * @param icon 图标
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
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
     * 父节点ID
     * @return pid 父节点ID
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 父节点ID
     * @param pid 父节点ID
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 父节点串
     * @return pids 父节点串
     */
    public String getPids() {
        return pids;
    }

    /**
     * 父节点串
     * @param pids 父节点串
     */
    public void setPids(String pids) {
        this.pids = pids == null ? null : pids.trim();
    }

    /**
     * 排序
     * @return orderid 排序
     */
    public String getOrderid() {
        return orderid;
    }

    /**
     * 排序
     * @param orderid 排序
     */
    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    /**
     * 启用状态
     * @return available 启用状态
     */
    public String getAvailable() {
        return available;
    }

    /**
     * 启用状态
     * @param available 启用状态
     */
    public void setAvailable(String available) {
        this.available = available == null ? null : available.trim();
    }
}