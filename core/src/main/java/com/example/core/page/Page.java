package com.example.core.page;

import lombok.Getter;

import java.io.Serializable;

/**
 * 分页对象
 *
 * @author sxy
 * @version 1.0
 * @date 2019/4/2 17:55
 **/
@Getter
public class Page implements Serializable {
    private Integer page;
    private Integer limit;

    public Page(Integer page, Integer limit) {
        this.page = page == null || page <= 0 ? 1 : page;
        this.limit = limit == null || limit < 0 ? 10 : limit;
    }

    public Page setPage(Integer page) {
        this.page = page == null || page <= 0 ? 1 : page;
        return this;
    }

    public Page setLimit(Integer limit) {
        this.limit = limit == null || limit < 0 ? 10 : limit;
        return this;
    }
}
