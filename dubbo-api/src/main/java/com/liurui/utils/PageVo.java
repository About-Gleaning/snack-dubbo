package com.liurui.utils;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName PageVo
 * @Description 分页vo
 * @Author liurui
 * @Date 2018/10/8 上午10:09
 **/
public class PageVo<T> implements Serializable {
    private Integer count;
    private Integer pageSize;
    private Integer page;
    private List<T> data;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
