package cn.ctide.pet.util;

/**
 * Created by Anker on 2017/3/17.
 */
public class Page {
    private Integer page;
    private Integer pageSize;

    public Integer getPage() {
        return (null==page||0==page)?1:page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return (null==pageSize||0==pageSize) ? 20: pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
