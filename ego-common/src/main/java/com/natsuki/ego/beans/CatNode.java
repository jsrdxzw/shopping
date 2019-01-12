package com.natsuki.ego.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-12
 * @Description:
 */
public class CatNode {
    @JsonProperty("u")
    private String url;
    @JsonProperty("n")
    private String name;
    @JsonProperty("i")
    private List<?> list;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
