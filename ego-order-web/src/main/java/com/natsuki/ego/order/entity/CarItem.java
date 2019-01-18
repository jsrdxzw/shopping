package com.natsuki.ego.order.entity;

import com.natsuki.ego.rpc.pojo.TbItem;

import java.io.Serializable;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-17
 * @Description: 购物车类
 */
public class CarItem implements Serializable {
    private TbItem item;
    private Integer num;

    public TbItem getItem() {
        return item;
    }

    public void setItem(TbItem item) {
        this.item = item;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "CarItem{" +
                "item=" + item +
                ", num=" + num +
                '}';
    }
}
