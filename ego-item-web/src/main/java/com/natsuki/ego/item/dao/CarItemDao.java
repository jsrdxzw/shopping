package com.natsuki.ego.item.dao;

import java.util.Map;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-17
 * @Description: 访问redis数据的方法
 */
public interface CarItemDao {

    /**
     * 保存购物车数据
     * @param uid 用户id
     * @param carMap 用户的购物车
     */
    void saveCarMap(String uid, Map<String,String> carMap);

    /**
     * 从redis中查找购物车集合
     * @param uid 用户id
     * @return map集合
     */
    Map<String,String> getCarMap(String uid);

    /**
     * 获得某个用户对应的商品的购物车对象
     * @param uid
     * @param itemId
     * @return
     */
    String getCarItem(String uid,String itemId);

    void updateCarMapNum(String uid,String itemId,String carItem);
}
