package com.natsuki.ego.search.entity;

import java.util.List;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-14
 * @Description:
 */
public class SearchResult {
    private List<Item> list;
    private Long maxPage;
    private Long total;

    public List<Item> getList() {
        return list;
    }

    public void setList(List<Item> list) {
        this.list = list;
    }

    public Long getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(Long maxPage) {
        this.maxPage = maxPage;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
