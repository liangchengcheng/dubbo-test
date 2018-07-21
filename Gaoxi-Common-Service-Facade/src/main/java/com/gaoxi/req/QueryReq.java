package com.gaoxi.req;

/**
 * 查询请求
 */
public class QueryReq extends AbsReq {

    /** 页码 */
    protected int page = 1;

    /** 每页显示的条数 */
    protected int numPerPage = 10;

    //当前行号
    protected int currentPage;

    public int getCurrentPage() {
        return (page-1)*numPerPage;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getNumPerPage() {
        return numPerPage;
    }

    public void setNumPerPage(int numPerPage) {
        this.numPerPage = numPerPage;
    }
}
