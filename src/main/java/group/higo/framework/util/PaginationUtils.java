package group.higo.framework.util;

public class PaginationUtils {
    //起始页数
    private Integer page;
    //显示条数
    private Integer rows;
    //起始页数
    private Integer start;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getStart() {
        return (this.page-1)*this.rows;
    }

    public void setStart(Integer start) {
        this.start = start;
    }
}
