package com.natsuki.ego.rpc.service;

import com.natsuki.ego.rpc.pojo.TbItemDesc;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-10
 * @Description: 商品描述信息
 */
public interface ItemDescService {
    /**
     * @param itemId 商品id
     * @return 商品描述信息
     */
    TbItemDesc getItemDesc(Long itemId);
}
