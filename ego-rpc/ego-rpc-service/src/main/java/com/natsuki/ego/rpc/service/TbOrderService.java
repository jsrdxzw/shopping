package com.natsuki.ego.rpc.service;

import com.natsuki.ego.rpc.pojo.TbOrder;
import com.natsuki.ego.rpc.pojo.TbOrderItem;
import com.natsuki.ego.rpc.pojo.TbOrderShipping;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-18
 * @Description:
 */
public interface TbOrderService {

    /**
     * 保存订单
     * @param order
     * @param item
     * @param orderShipping
     */
    void saveTbOrder(TbOrder order, TbOrderItem item, TbOrderShipping orderShipping);
}
