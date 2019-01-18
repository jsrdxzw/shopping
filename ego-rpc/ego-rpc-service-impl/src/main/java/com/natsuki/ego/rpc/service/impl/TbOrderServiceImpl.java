package com.natsuki.ego.rpc.service.impl;

import com.natsuki.ego.rpc.mapper.TbOrderItemMapper;
import com.natsuki.ego.rpc.mapper.TbOrderMapper;
import com.natsuki.ego.rpc.mapper.TbOrderShippingMapper;
import com.natsuki.ego.rpc.pojo.TbOrder;
import com.natsuki.ego.rpc.pojo.TbOrderItem;
import com.natsuki.ego.rpc.pojo.TbOrderShipping;
import com.natsuki.ego.rpc.service.TbOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-18
 * @Description:
 */
@Service
public class TbOrderServiceImpl implements TbOrderService {

    @Autowired
    private TbOrderMapper orderMapper;
    @Autowired
    private TbOrderItemMapper orderItemMapper;
    @Autowired
    private TbOrderShippingMapper orderShippingMapper;

    @Override
    public void saveTbOrder(TbOrder order, TbOrderItem item, TbOrderShipping orderShipping) {
        orderMapper.insert(order);
        orderItemMapper.insert(item);
        orderShippingMapper.insert(orderShipping);
    }
}
