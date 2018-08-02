package group.higo.framework.util;

import java.util.List;

/**
 * ZTree 封装类
 * 后续扩展其他的参数
 * @author Longruan
 *
 */
public class MyTree {

    private String id;
    private String text;
    private boolean open;
    private List<MyTree> children;
    private Object obj;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public boolean isOpen() {
        return open;
    }
    public void setOpen(boolean open) {
        this.open = open;
    }
    public List<MyTree> getChildren() {
        return children;
    }
    public void setChildren(List<MyTree> children) {
        this.children = children;
    }
    public Object getObj() {
        return obj;
    }
    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
