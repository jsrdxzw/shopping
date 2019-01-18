package com.natsuki.ego.order.service;

import com.natsuki.ego.order.entity.CarItem;

import java.util.Map;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-18
 * @Description:
 */
public interface OrderService {

    /**
     * 加载用户购物车集合
     * @param id
     * @return
     */
    Map<Long, CarItem> getCarItemMap(Long id);

}
