package com.natsuki.ego.order.dao;

import java.util.Map;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-18
 * @Description:
 */
public interface CarItemDao {

    /**
     * 从redis中获得用户订单数据
     * @param uid 用户id
     * @return 订单数据
     */
    Map<String,String> getCarItemMap(String uid);

    /**
     * 清空购物车
     * @param uid
     */
    void deleteCarItemMap(String uid);
}
