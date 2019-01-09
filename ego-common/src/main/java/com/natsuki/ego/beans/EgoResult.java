package com.natsuki.ego.beans;

import java.io.Serializable;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-09
 * @Description: 封装客户端的上架，下架，删除商品请求相应的数据模型
 */
public class EgoResult implements Serializable {


    /**
     * 响应状态
     */
    private Integer status;
    private Object data;

    private String msg;

    public EgoResult(Integer status, Object data, String msg) {
        this.status = status;
        this.data = data;
        this.msg = msg;
    }

    public EgoResult(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public EgoResult(Object data) {
        this.data = data;
        this.status = 200;
        this.msg = "ok";
    }

    public EgoResult() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static EgoResult ok(){
        return new EgoResult(null);
    }
}
