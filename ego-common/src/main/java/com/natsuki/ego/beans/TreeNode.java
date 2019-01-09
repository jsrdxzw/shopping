package com.natsuki.ego.beans;

import java.io.Serializable;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-09
 * @Description: 封装树控件需要的数据模型
 */
public class TreeNode implements Serializable {
    private Long id;
    private String text;
    private String state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
