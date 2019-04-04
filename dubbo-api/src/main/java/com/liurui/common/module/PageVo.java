package com.liurui.common.module;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * @ClassName PageVo
 * @Description 分页vo
 * @Author liurui
 * @Date 2018/10/8 上午10:09
 **/
public class PageVo<T> implements IPage {
    private Integer total;
    private Integer size;
    private Integer current;
    private List<T> recordst;


    @Override
    public List getRecords() {
        return null;
    }

    @Override
    public IPage setRecords(List list) {
        return null;
    }

    @Override
    public long getTotal() {
        return 0;
    }

    @Override
    public IPage setTotal(long l) {
        return null;
    }

    @Override
    public long getSize() {
        return 0;
    }

    @Override
    public IPage setSize(long l) {
        return null;
    }

    @Override
    public long getCurrent() {
        return 0;
    }

    @Override
    public IPage setCurrent(long l) {
        return null;
    }
}
