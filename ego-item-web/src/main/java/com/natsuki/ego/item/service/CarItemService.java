package com.natsuki.ego.item.service;

import com.natsuki.ego.item.entity.CarItem;

import java.util.Map;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-17
 * @Description:
 */
public interface CarItemService {

    /**
     * 将商品放入购物车
     * @param itemId 商品id
     * @param uid 用户id
     */
    void addItemToCar(Long itemId,Long uid);

    /**
     * 加载用户购物车列表
     * @param uid
     * @return
     */
    Map<Long, CarItem> getCarItemList(Long uid);

    /**
     * 更新商品数量
     * @param itemId
     * @param uid
     * @param num
     * @return
     */
    String updateCarItemNum(Long itemId,Long uid,Integer num);

}
